package com.crecc.sale.service;

import com.crecc.sale.domain.Invoice;
import com.crecc.sale.domain.SoftwareOrder;
import com.crecc.sale.service.exception.NoContentException;
import com.crecc.sale.web.dto.InvoiceDTO;
import com.crecc.sale.web.dto.SoftwareOrderDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiyuanbupt on 2018/12/2.
 */

@Transactional
public interface SoftwareOrderService {

    @Transactional
    SoftwareOrder orderSoftware(SoftwareOrderDTO orderDTO);

    /**
     * 查找所有的订单
     */
    @Transactional
    List<SoftwareOrder> getAllOrder();

    /**
     * 所有没有开票的订单
     * @return
     */
    @Transactional
    List<SoftwareOrder> getOrderNotInvoiced();

    /**
     * 获得所有未出库的订单
     * @return
     */
    @Transactional
    List<SoftwareOrder> getOrderNotOutStocked();

    /**
     * 获得所有未邮寄的订单
     * @return
     */
    @Transactional
    List<SoftwareOrder> getOrderNotPosted();

    /**
     * 根据id获得订单详细信息
     * @param id
     * @return
     */
    @Transactional
    SoftwareOrder getOrderById(Long id) throws NoContentException;

    /**
     * 根据id删除, 开票成功的订单不可删除
     * @param id
     */
    @Transactional
    void deleteOrderById(Long id) throws NoContentException;

    @Transactional
    Invoice postInvoice(InvoiceDTO invoiceDTO) throws NoContentException;
}
