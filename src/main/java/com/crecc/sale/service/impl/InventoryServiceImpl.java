package com.crecc.sale.service.impl;

import com.crecc.sale.dao.*;
import com.crecc.sale.domain.*;
import com.crecc.sale.service.InventoryService;
import com.crecc.sale.service.exception.CannotDeleteResourceException;
import com.crecc.sale.service.exception.IlegalParameterException;
import com.crecc.sale.service.exception.NoContentException;
import com.crecc.sale.web.dto.InvoiceDTO;
import com.crecc.sale.web.dto.OutStockDTO;
import com.crecc.sale.web.dto.PostDTO;
import com.crecc.sale.web.inventory.InventoryException;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import static com.crecc.sale.util.LockNumHelper.*;
/**
 * Created by xiyuanbupt on 2018/11/29.
 */

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    InStockRespository inStockRespository;
    @Autowired
    OutStockRespository outStockRespository;
    @Autowired
    InvoiceRespository invoiceRespository;
    @Autowired
    DailyOutStockRespository dailyOutStockRespository;
    @Autowired
    SoftwareOrderRespository softwareOrderRespository;
    @Autowired
    InvoiceInfoRespository invoiceInfoRespository;
    @Autowired
    LockRespository lockRespository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PostRespository postRespository;

    public static Logger logger = Logger.getLogger(InventoryServiceImpl.class.getName());

    /**
     * 获得加密锁的入库次数
     * @param isNet
     * @return
     */
    @Override
    @Transactional
    public Integer getInStockCount(Boolean isNet) {
        if(isNet){
            return inStockRespository.getNetInstockCount();
        }else {
            return inStockRespository.getInstockCount();
        }
    }

    @Override
    @Transactional
    public OutStock outStock(OutStockDTO outStockDTO) throws InventoryException {
        /**
         * 首先查询对应的订单是否存在 -> 查询是否有对应的开票信息存在 -> 查询出库的加密锁是否有库存
         * 填写发票信息, 扣减库存, 出库信息记录
         */
        if(!softwareOrderRespository.existsById(outStockDTO.getSoftwareOrderId())){
            throw new InventoryException(String.format("订单id:%d不存在", outStockDTO.getSoftwareOrderId()));
        }
        for(InvoiceDTO invoiceDTO:outStockDTO.getInvoices()){
            if(!invoiceInfoRespository.existsById(invoiceDTO.getInvoiceInfoId())){
                throw new InventoryException(String.format("InvoiceInfo not exists, id:%d", invoiceDTO.getInvoiceInfoId()));
            }
        }
        OutStock outStock = modelMapper.map(
                outStockDTO, OutStock.class
        );
        // 查询是否有库存
        // // TODO: 2018/12/4 查询加密锁是否已经出库
        for(Integer num:outStockDTO.getLockNums()){
            // 首先检查是否有库存
            // 标记加密锁出库
            markLockOutStock(outStock, num, false);
            
            // // TODO: 2018/12/5 验证一下时间戳问题, 查看一下是否会出现问题 
            DailyOutStock dailyOutStock = getTodayDailyOutStock(false);
            // 如果是当天初次出库
            if(dailyOutStock.getStartNum() == null){
                dailyOutStock.setStartNum(num);
            }
            dailyOutStock.setEndNum(num);
            dailyOutStock.setCount(dailyOutStock.getCount() + 1);
            dailyOutStock.setAfterCount(dailyOutStock.getAfterCount() - 1);
            dailyOutStockRespository.save(dailyOutStock);
        }
        outStockRespository.save(outStock);
        return outStock;
    }

    //** 如果没有今天的记录, 就重新创建, 如果有直接返回
    DailyOutStock getTodayDailyOutStock(Boolean isNet){
        // // TODO: 2018/12/5 验证一下时间戳问题, 查看一下是否会出现问题
        Date today = new Date(System.currentTimeMillis());
        Optional<DailyOutStock> dailyOutStockOptional;
        dailyOutStockOptional = dailyOutStockRespository.findByOutDateAndIsNetLock(
                today,isNet
        );
        DailyOutStock dailyOutStock;
        if(!dailyOutStockOptional.isPresent()){
            dailyOutStock = new DailyOutStock();
            dailyOutStock.setOutDate(today);
            dailyOutStock.setNetLock(isNet);
            // 出库数量为0
            dailyOutStock.setCount(0);
            Integer count = inStockRespository.getRemainLockCount();
            dailyOutStock.setBeforeCount(count);
            dailyOutStock.setAfterCount(count);
        }else {
            dailyOutStock = dailyOutStockOptional.get();
        }
        return dailyOutStock;
    }

    private void markLockOutStock(OutStock outStock, Integer num, Boolean isNet) throws InventoryException{
        Optional<Lock> lockOptional = lockRespository.findByNumAndIsNetLock(num, isNet);
        if(!lockOptional.isPresent()){
            throw new InventoryException(String.format("Lock num %d does not exists", num));
        }
        Lock lock = lockOptional.get();
        if(lock.getOutStock()!= null){
            throw new InventoryException(String.format("Lock num %d already out stock", num));
        }
        lock.setOutStock(outStock);
        outStock.addLock(lock);
        lockRespository.save(lock);
        /**
         * 减库存
         */
        inStockRespository.reduceStorage(lock.getInStock().getId());
    }

    /**
     * 获得所有的加密锁入库记录
     * @param isNet
     * @return
     */
    @Override
    @Transactional
    public List<InStock> getAll(Boolean isNet) {
        if(isNet){
            return inStockRespository.findByIsNetLockTrue();
        }else {
            return inStockRespository.findByIsNetLockFalse();
        }
    }

    @Override
    @Transactional
    public List<InStock> pageableSearchStock(Boolean isNet, Integer page, Integer size) throws NoContentException{
        Sort sort = new Sort(Sort.Direction.DESC, "inDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<InStock> stocks;
        if(isNet){
            stocks = inStockRespository.findByIsNetLockTrue(pageable);
        }else {
            stocks = inStockRespository.findByIsNetLockFalse(pageable);
        }
        //logger.info("Pageable search stock, isNet:{}, page:{}, size:P{}, resSize:{}", isNet, page, size, stocks.getTotalPages());
        if(!stocks.hasContent()){
            throw new NoContentException(String.format("Out of range, in stock page: %d, size:%d, isNet:%b had no content.",page, size, isNet));
        }
        return stocks.getContent();
    }

    @Override
    @Transactional
    public void delteInStockById(Long id) throws CannotDeleteResourceException{
        /**
         * 不可以删除已经有出库的加密锁
         */
        /**
        InStock inStock = inStockRespository.findById(id);
         **/
        Optional<InStock> inStockOptional = inStockRespository.findById(id);
        if(!inStockOptional.isPresent()){
            throw new CannotDeleteResourceException("入库记录不存在");
        }
        InStock inStock = inStockOptional.get();
        if(!inStock.getCount().equals(inStock.getRemainCount())){
            throw new CannotDeleteResourceException(String.format("已有加密锁出库, 无法删除, 入库id:%d", id));
        }
        lockRespository.deleteLockByInStockId(id);
        inStockRespository.deleteById(id);
        // 删除的加密锁不应该体现在日报中
        DailyOutStock dailyOutStock = getTodayDailyOutStock(inStock.getNetLock());
        Integer count = inStock.getCount();
        dailyOutStock.setInCount(dailyOutStock.getInCount() - count);
        dailyOutStock.setAfterCount(dailyOutStock.getAfterCount() - count);
        dailyOutStockRespository.save(dailyOutStock);
        //encryptionLockStockRespository.deleteById(lockStock.getId());
    }

    @Override
    @Transactional
    public InStock inStock(Integer count, Integer startNum, Integer endNum, Boolean isNet, Date inDate, String remark, String producerName, String receiverName)throws IlegalParameterException {
        judgeLockNumberLegal(startNum, endNum, count);
        judgeLockNumNotInStock(startNum, endNum);
        InStock inStock = new InStock();
        /**
         * 首先查看库存有多少剩余数量
         */
        inStock.setInDate(inDate);
        inStock.setNetLock(isNet);
        inStock.setCount(count);
        Integer beforeCount;
        if(isNet){
            inStock.setBeforeCount(
                    beforeCount = inStockRespository.getRemainNetLockCount()
            );
        }else {

            inStock.setBeforeCount(
                    beforeCount = inStockRespository.getRemainLockCount()
            );
        }
        inStock.setAfterCount(beforeCount + count);
        inStock.setStartNum(startNum);
        inStock.setEndNum(endNum);
        inStock.setRemark(remark);
        inStock.setProducerName(producerName);
        inStock.setReceiverName(receiverName);
        inStock.setRemainCount(count);
        //// TODO: 2018/11/29  完成制作人, 接收人, 备注的填写
        /**
         * 建立库存
         */
        //// TODO: 2018/12/5 更新日报
        DailyOutStock dailyOutStock = getTodayDailyOutStock(isNet);
        dailyOutStock.setInCount(dailyOutStock.getInCount() + count);
        dailyOutStock.setAfterCount(dailyOutStock.getAfterCount() + count);
        dailyOutStock.setStartNum(0);
        dailyOutStock.setEndNum(0);
        dailyOutStockRespository.save(dailyOutStock);
        List<Lock> locks = creatLockEntitys(startNum, endNum, inStock, isNet);
        lockRespository.saveAll(locks);
        return inStockRespository.save(inStock);
    }

    @Override
    @Transactional(rollbackFor = IlegalParameterException.class)
    public InStock inStock(Integer count, Integer startNum, Integer endNum, Boolean isNet, Date inDate) throws IlegalParameterException {
        judgeLockNumberLegal(startNum, endNum, count);
        judgeLockNumNotInStock(startNum, endNum);
        InStock inStock = new InStock();
        /**
         * 首先查看库存有多少剩余数量
         */
        inStock.setInDate(inDate);
        inStock.setNetLock(isNet);
        inStock.setCount(count);
        Integer beforeCount;
        if(isNet){
            inStock.setBeforeCount(
                    beforeCount = inStockRespository.getRemainNetLockCount()
            );
        }else {

            inStock.setBeforeCount(
                    beforeCount = inStockRespository.getRemainLockCount()
            );
        }
        inStock.setAfterCount(beforeCount + count);
        inStock.setStartNum(startNum);
        inStock.setEndNum(endNum);
        //// TODO: 2018/11/29  完成制作人, 接收人, 备注的填写

        //// TODO: 2018/12/5 更新日报
        DailyOutStock dailyOutStock = getTodayDailyOutStock(isNet);
        dailyOutStock.setInCount(dailyOutStock.getInCount() + count);
        dailyOutStock.setAfterCount(dailyOutStock.getAfterCount() + count);
        dailyOutStock.setStartNum(0);
        dailyOutStock.setEndNum(0);
        dailyOutStockRespository.save(dailyOutStock);
        /**
         * 建立库存
         */
        List<Lock> locks = creatLockEntitys(startNum, endNum, inStock, isNet);
        lockRespository.saveAll(locks);
        //// TODO: 2018/12/5 更新日报
        return inStockRespository.save(inStock);
    }

    @Override
    @Transactional
    public Post postSoftware(PostDTO postDTO) throws InventoryException {
        Optional<SoftwareOrder> softwareOrderOptional = softwareOrderRespository.findById(postDTO.getSoftwareOrderId());
        if(!softwareOrderOptional.isPresent()){
            throw new InventoryException(String.format("Soft ware order not exist, order id: %d", postDTO.getSoftwareOrderId()));
        }
        Post post = modelMapper.map(postDTO, Post.class);
        post.setSoftwareOrder(softwareOrderOptional.get());
        return postRespository.save(post);
    }

    private List<Lock> creatLockEntitys(Integer startNum, Integer endNum, InStock inStock, Boolean isNet){
        List<Lock> locks = new ArrayList<>(endNum - startNum + 1);
        for(Integer i = startNum; i<=endNum; i++){
            Lock lock = new Lock();
            lock.setInStock(inStock);
            lock.setNetLock(isNet);
            lock.setNum(i);
            locks.add(lock);
        }
        return locks;
    }

    private void judgeLockNumberLegal(Integer startNum, Integer endNum, Integer count) throws IlegalParameterException{
        if(!isLockNumLegal(startNum)) {
            throw new IlegalParameterException(String.format("加密锁起始编号不合法, satrtNum:%d, endNum:%d, count:%d", startNum, endNum, count));
        }
        if(!isLockNumLegal(endNum)){
            throw new IlegalParameterException(String.format("加密锁终止编号不合法, satrtNum:%d, endNum:%d, count:%d", startNum, endNum, count));
        }
        if(count < 0 || count != endNum - startNum + 1){
            throw new IlegalParameterException(String.format("入库数量与加密锁编号不相符, satrtNum:%d, endNum:%d, count:%d", startNum, endNum, count));
        }
    }

    private void judgeLockNumNotInStock(Integer startNum, Integer endNum) throws IlegalParameterException{
        //// TODO: 2018/11/30 程序暂时不负责检查加密锁是否在库存中, 直接入库
    }
}
