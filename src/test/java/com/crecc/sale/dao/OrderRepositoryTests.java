package com.crecc.sale.dao;

import com.crecc.sale.domain.SoftwareOrder;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;


/**
 * Created by xiyuanbupt on 2018/11/23.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTests {

    @Autowired
    private SoftwareOrderRespository softwareOrderRespository;

    @Test
    public void test(){
        SoftwareOrder softwareOrder = new SoftwareOrder(
                "xiyuan","18810541263", "crecc", "中国建设银行会城门支行",
                 new Date(System.currentTimeMillis())
                );
        softwareOrderRespository.save(softwareOrder);
        System.out.println(softwareOrderRespository.findAll().get(0));
        Assert.assertEquals(1, softwareOrderRespository.findAll().size());
    }
}
