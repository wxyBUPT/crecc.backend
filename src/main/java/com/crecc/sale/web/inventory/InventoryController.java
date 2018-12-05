package com.crecc.sale.web.inventory;

import com.crecc.sale.dao.LockRespository;
import com.crecc.sale.domain.*;
import com.crecc.sale.service.InventoryService;
import com.crecc.sale.service.exception.CannotDeleteResourceException;
import com.crecc.sale.service.exception.IlegalParameterException;
import com.crecc.sale.service.exception.NoContentException;
import com.crecc.sale.web.dto.*;
import com.crecc.sale.web.dvo.OutStockDVO;
import com.crecc.sale.web.dvo.PostDVO;
import com.crecc.sale.web.dvo.SoftwareOrderDVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xiyuanbupt on 2018/11/28.
 */

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    LockRespository lockRespository;

    @ApiOperation(value = "以时间排序分页查询加密锁入库记录", notes = "")
    @RequestMapping(value = "/in_stocks", method = RequestMethod.GET)
    public List<ResInStockDTO> getInStockList(
            @RequestParam("page") Integer page,
            @RequestParam("pageSize")  Integer pageSize,
            @RequestParam("isNet") Boolean isNet) throws NoContentException{
        List<InStock> inStockList = inventoryService.pageableSearchStock(isNet, page, pageSize);
        return inStockList.stream()
                .map(inStock -> convertInStockToDto(inStock))
                .collect(Collectors.toList());

    }

    @ApiOperation(value = "获得所有的加密锁入库记录")
    @RequestMapping(value = "/in_stocks/all", method = RequestMethod.GET)
    public List<ResInStockDTO> getAllInStock(
            @RequestParam("isNet") Boolean isNet
    ){
        List<InStock> inStockList = inventoryService.getAll(isNet);
        return inStockList.stream()
                .map(inStock -> convertInStockToDto(inStock))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "获得加密锁入库次数")
    @RequestMapping(value = "/in_stocks/count", method = RequestMethod.GET)
    public ResInStockCountDTO getInStockCount(
            @RequestParam("isNet")Boolean isNet
    ){
        ResInStockCountDTO resInStockCountDTO = new ResInStockCountDTO();
        resInStockCountDTO.setNet(isNet);
        resInStockCountDTO.setCount(inventoryService.getInStockCount(isNet));
        return resInStockCountDTO;
    }


    private ResInStockDTO convertInStockToDto(InStock inStock){
        ResInStockDTO resInStockDTO = modelMapper.map(inStock, ResInStockDTO.class);
        resInStockDTO.setRemainCount(
                inStock.getRemainCount()
        );
        return resInStockDTO;
    }

    @ApiOperation(value = "加密锁入库记录删除", notes = "多数情况下不会被使用")
    @ApiImplicitParam(name = "inStockId", value = "加密锁入库编号", paramType = "path", dataType = "Long")
    @RequestMapping(value = "/in_stocks/{inStockId}", method = RequestMethod.DELETE)
    public void deleteInStock(@PathVariable  Long inStockId) throws CannotDeleteResourceException{
        inventoryService.delteInStockById(inStockId);
    }

    // // TODO: 2018/12/4 应当做一些更改 
    @ApiOperation(value = "加密锁出库", notes = "加密锁出库, 连同发票信息也一起填写")
    @ApiImplicitParam(name = "outStockDTO", value = "出库的详细实体", dataType = "OutStockDTO")
    @RequestMapping(value = "/out_stocks", method = RequestMethod.POST)
    public OutStockDVO postOutStock(@RequestBody OutStockDTO outStockDTO) throws InventoryException{
        // 记录发票号码, 记录出库单等信息

        OutStock outStock = inventoryService.outStock(outStockDTO);
        OutStockDVO outStockDVO = modelMapper.map(
                outStock, OutStockDVO.class
        );
        System.out.println(outStock);
        List<Integer> saledLocksNum = new ArrayList<>(outStock.getLocks().size());
        for(Lock lock:outStock.getLocks()){
            saledLocksNum.add(lock.getNum());
        }
        outStockDVO.setSaledLocks(saledLocksNum);
        return outStockDVO;
    }

    @ApiOperation(value = "加密锁入库", notes = "")
    @ApiImplicitParam(name = "inStockDTO", value = "入库详细实体", dataType = "InStockDTO")
    @RequestMapping(value = "/in_stocks", method = RequestMethod.POST)
    public ResInStockDTO postInStock(@RequestBody InStockDTO inStockDTO)throws InventoryException{
        /**
         * 验证数据的有效性
         * 检查数据库中是否有这些加密锁
         * 执行加密锁的一系列入库操作
         */
        /**
        if(true){
            throw new InventoryException("随便的错误");
        }
         **/
        InStock inStock = null;
        try {
            inStock = inventoryService.inStock(
                    inStockDTO.getCount(), inStockDTO.getStartNum(), inStockDTO.getEndNum(),
                    inStockDTO.getNetLock(), inStockDTO.getInDate(), inStockDTO.getRemark(),
                    inStockDTO.getProducerName(), inStockDTO.getReceiverName()
            );
        }catch (IlegalParameterException e){
            throw new InventoryException(e.getMessage());
        }
        if(inStock == null){
            throw new InventoryException("插入入库信息失败");
        }
        ResInStockDTO resInStockDTO = modelMapper.map(inStock, ResInStockDTO.class);
        resInStockDTO.setRemainCount(inStock.getCount());
        return resInStockDTO;
    }

    @ApiOperation(value = "添加邮寄信息", notes = "")
    @ApiImplicitParam(name = "postDTO", value = "邮寄详细实体", dataType = "PostDTO")
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public PostDVO postSoftware(@RequestBody PostDTO postDTO) throws InventoryException{
        Post post = inventoryService.postSoftware(postDTO);
        return modelMapper.map(
                post, PostDVO.class
        );
    }
}
