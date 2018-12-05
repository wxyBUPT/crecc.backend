package com.crecc.sale.web.order;

import com.crecc.sale.domain.Invoice;
import com.crecc.sale.domain.SoftwareOrder;
import com.crecc.sale.service.SoftwareOrderService;
import com.crecc.sale.service.exception.NoContentException;
import com.crecc.sale.web.dto.InvoiceDTO;
import com.crecc.sale.web.dto.SoftwareOrderDTO;
import com.crecc.sale.web.dvo.InvoiceDVO;
import com.crecc.sale.web.dvo.SoftwareOrderDVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by xiyuanbupt on 2018/12/2.
 */
@RestController
@RequestMapping(value = "/software_orders")
public class OrderController {

    @Autowired
    SoftwareOrderService softwareOrderService;
    @Autowired
    ModelMapper modelMapper;
    private static final Type softwareOrderDVOListClass = new TypeToken<List<SoftwareOrderDVO>>(){}.getType();

    @ApiOperation(value = "添加新的订单", notes = "")
    @ApiImplicitParam(name = "softwareOrderDTO", value = "订单详细实体", dataType = "SoftwareOrderDTO")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public SoftwareOrderDVO postSoftwareOrder(@RequestBody SoftwareOrderDTO softwareOrderDTO){
        SoftwareOrder softwareOrder = softwareOrderService.orderSoftware(softwareOrderDTO);
        SoftwareOrderDVO softwareOrderDVO = modelMapper.map(
                softwareOrder, SoftwareOrderDVO.class
        );
        return softwareOrderDVO;
    }

    @ApiOperation(value = "填写开票信息", notes = "")
    @ApiImplicitParam(name = "invoiceDTO", value = "开票信息实体", dataType = "InvoiceDTO")
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    public InvoiceDVO postInvoice(@RequestBody InvoiceDTO invoiceDTO) throws NoContentException{
        Invoice invoice = softwareOrderService.postInvoice(invoiceDTO);
        InvoiceDVO invoiceDVO = modelMapper.map(
                invoice, InvoiceDVO.class
        );
        invoiceDVO.setInvoiceInfoId(
                invoice.getInvoiceInfo().getId()
        );
        return invoiceDVO;
    }


    @ApiOperation(value = "获得所有的订单")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<SoftwareOrderDVO> getAllOrder(){
        return modelMapper.map(
                softwareOrderService.getAllOrder(), softwareOrderDVOListClass
        );
    }

    @ApiOperation(value = "获得没有开发票的订单")
    @RequestMapping(value = "/not_invoiced", method = RequestMethod.GET)
    public List<SoftwareOrderDVO> getOrderNotInvoiced(){
        return modelMapper.map(
                softwareOrderService.getOrderNotInvoiced(), softwareOrderDVOListClass
        );
    }

    @ApiOperation(value = "获得没有发生出库的订单")
    @RequestMapping(value = "/not_outstocked", method = RequestMethod.GET)
    public List<SoftwareOrderDVO> getOrderNotOutStocked(){
        return modelMapper.map(
                softwareOrderService.getOrderNotOutStocked(), softwareOrderDVOListClass
        );
    }

    @ApiOperation(value = "获得没有邮寄的订单")
    @RequestMapping(value = "/not_posted", method = RequestMethod.GET)
    public List<SoftwareOrderDVO> getOrderNotPosted(){
        return modelMapper.map(
                softwareOrderService.getOrderNotPosted(), softwareOrderDVOListClass
        );
    }

    public SoftwareOrderDVO getOrderById(Long id)throws NoContentException{
        return modelMapper.map(
                softwareOrderService.getOrderById(id), SoftwareOrderDVO.class
        );
    }

    public void deleteOrderById(Long id) throws NoContentException{
        softwareOrderService.deleteOrderById(id);
    }
}
