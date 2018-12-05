package com.crecc.sale.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xiyuanbupt on 2018/11/17.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTests {

    @Autowired
    private UserService userService;

    @Before
    public void setUp(){
        userService.deleteAllUsers();
    }

    @Test
    public void test() throws Exception{
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);

        Assert.assertEquals(5, userService.getAllUsers().intValue());
    }
}
