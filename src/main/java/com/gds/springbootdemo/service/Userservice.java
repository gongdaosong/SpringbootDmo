package com.gds.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;

/**
 * @Author 龚道松
 * @Date 2019/5/26 17:20
 * @Wersion 1.0
 **/
@Service
public class Userservice {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUser(String name, Integer age){
        System.out.println("createUser");
        jdbcTemplate.update("insert into users values(id,?,?);", name,age);
        System.out.println("创建用户成功。。。。");
    }
}
