package com.gds.springbootdemo.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author 龚道松
 * @Date 2019/3/16 0016 15:36
 * @Wersion 1.0
 **/
//@RestController
@Controller
@Slf4j
public class ApplicationControoler {

    @ResponseBody
    @RequestMapping("/aaa")
    public Object aaa( ) {

        List<String> listResult = new ArrayList<String>();
        listResult.add("zhangsan");
        listResult.add("lisi");
        listResult.add("itmayiedu");

        return listResult;
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
