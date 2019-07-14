package com.gds.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author 龚道松
 * @Date 2019/7/14 10:54
 * @Version 1.0
 *      登录的controller
 **/

@Controller
public class LoginController {

    /**
     * 登录请求
     * @return
     */

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> Map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            // 登录成功 把用户名保存到session中
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            // 登录失败
            Map.put("msg","用户名或者密码错误！");
            return "login";
        }

    }
}
