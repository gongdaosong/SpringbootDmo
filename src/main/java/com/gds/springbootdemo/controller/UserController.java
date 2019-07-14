package com.gds.springbootdemo.controller;

import com.gds.springbootdemo.dao.UserDao;
import com.gds.springbootdemo.entity.User;
import com.gds.springbootdemo.mapper.UserMapper;
import com.gds.springbootdemo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author 龚道松
 * @Date 2019/5/26 17:30
 * @Wersion 1.0
 **/
@RestController
public class UserController {

    @Autowired
    private Userservice userservice;
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/createUser")
    public String createUser(String username, Integer age){
        userservice.createUser(username, age);
    return "success";
    }

    @RequestMapping("/getUser")
    public User getUser(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @RequestMapping("/findByName")
   // @ResponseBody
    public User findByName(String username){
        return userMapper.findByName(username);
    }

    @RequestMapping("/insert")
  //  @ResponseBody
    public String inster(String username, Integer age){
        userMapper.insert(username, age);
        return "success";
    }
}
