package com.crecc.sale.learn;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by xiyuanbupt on 2018/11/17.
 */
public class JDBCTemplateDemo {

    @Test
    public void demo(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///crecc");
        dataSource.setUsername("root");
        dataSource.setPassword("111");
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.execute("create table if not EXISTS test(id int primary key,name varchar(32))");
    }
}