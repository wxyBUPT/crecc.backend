package com.crecc.sale.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xiyuanbupt on 2018/11/23.
 * dao层购买流程测试
 * 网络锁入库 -> 单机锁入库 -> 销售人员填写订单(各种类型的订单,相关的开票信息) -> 查询订单 -> 出库 -> 邮寄
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private InsideStatusRespository insideStatusRespository;

    @Autowired
    private InStockRespository inStockRespository;

    @Autowired
    private InvoiceInfoRespository invoiceInfoRespository;

    @Autowired
    private InvoiceRespository invoiceRespository;

    @Autowired
    private OutStockRespository outStockRespository;

    @Autowired
    private PostRespository postRespository;

    @Autowired
    private SoftwareOrderRespository softwareOrderRespository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){

    }
}
