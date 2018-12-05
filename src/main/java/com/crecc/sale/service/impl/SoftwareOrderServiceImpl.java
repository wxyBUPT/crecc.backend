package com.crecc.sale.service.impl;

import com.crecc.sale.dao.InvoiceInfoRespository;
import com.crecc.sale.dao.InvoiceRespository;
import com.crecc.sale.dao.SoftwareOrderRespository;
import com.crecc.sale.domain.Invoice;
import com.crecc.sale.domain.InvoiceInfo;
import com.crecc.sale.domain.SoftwareOrder;
import com.crecc.sale.service.SoftwareOrderService;
import com.crecc.sale.service.exception.NoContentException;
import com.crecc.sale.web.dto.InvoiceDTO;
import com.crecc.sale.web.dto.SoftwareOrderDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by xiyuanbupt on 2018/12/2.
 */

@Service
public class SoftwareOrderServiceImpl implements SoftwareOrderService {

    @Autowired
    SoftwareOrderRespository softwareOrderRespository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    InvoiceInfoRespository invoiceInfoRespository;
    @Autowired
    InvoiceRespository invoiceRespository;

    public SoftwareOrderServiceImpl() {
    }

    private SoftwareOrder convertInStockDto2InStock(SoftwareOrderDTO softwareOrderDTO){
        SoftwareOrder softwareOrder = modelMapper.map(
                softwareOrderDTO, SoftwareOrder.class
        );
        return softwareOrder;
    }

    @Override
    @Transactional
    public SoftwareOrder orderSoftware(SoftwareOrderDTO orderDTO) {
        SoftwareOrder softwareOrder = convertInStockDto2InStock(orderDTO);
        Set<InvoiceInfo> invoiceInfos = softwareOrder.getInvoiceInfos();
        for(InvoiceInfo invoiceInfo:invoiceInfos){
            invoiceInfo.setSoftwareOrder(softwareOrder);
        }
        //System.out.println(softwareOrder);

        softwareOrder = softwareOrderRespository.save(softwareOrder);

        /**
        for(InvoiceInfo invoiceInfo:invoiceInfos){
            invoiceInfo.setSoftwareOrder(softwareOrder);
            System.out.println(invoiceInfo);
            invoiceInfoRespository.save(invoiceInfo);
            System.out.println(invoiceInfo);
        }
        softwareOrder.setInvoiceInfos(invoiceInfos);
         **/
        return softwareOrder;
    }

    @Override
    public List<SoftwareOrder> getAllOrder() {
        return softwareOrderRespository.findAll();
    }

    @Override
    public List<SoftwareOrder> getOrderNotInvoiced() {
        return softwareOrderRespository.findByInvoicedFalse();
    }

    @Override
    public List<SoftwareOrder> getOrderNotOutStocked() {
        return softwareOrderRespository.findByOutStockNotNull();
    }

    @Override
    public List<SoftwareOrder> getOrderNotPosted() {
        return softwareOrderRespository.findByPostNotNull();
    }

    @Override
    public SoftwareOrder getOrderById(Long id) throws NoContentException {
        Optional<SoftwareOrder> softwareOrderOptional = softwareOrderRespository.findById(id);
        if(!softwareOrderOptional.isPresent()){
            throw new NoContentException(String.format("订单编号 id:%l 不存在", id));
        }
        return softwareOrderOptional.get();
    }

    @Override
    public void deleteOrderById(Long id) throws NoContentException {
        Optional<SoftwareOrder> softwareOrderOptional = softwareOrderRespository.findById(id);
        if(!softwareOrderOptional.isPresent()){
            throw new NoContentException(String.format("订单编号 id:%l 不存在", id));
        }
        softwareOrderRespository.deleteById(id);
    }

    @Override
    public Invoice postInvoice(InvoiceDTO invoiceDTO) throws NoContentException{
        System.out.println(invoiceDTO);
        invoiceRespository.setInvoiceIsInvalid(invoiceDTO.getInvoiceInfoId());
        Optional<InvoiceInfo> invoiceInfoOptional = invoiceInfoRespository.findById(invoiceDTO.getInvoiceInfoId());
        if(!invoiceInfoOptional.isPresent()){
            throw new NoContentException(String.format(
                    "Invoice_info id:%d do not exist", invoiceDTO.getInvoiceInfoId()
            ));
        }
        Invoice invoice = modelMapper.map(
                invoiceDTO, Invoice.class
        );
        invoice.setInvoiceInfo(invoiceInfoOptional.get());
        return invoiceRespository.save(invoice);
    }
}
