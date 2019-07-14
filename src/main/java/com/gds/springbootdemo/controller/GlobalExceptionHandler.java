package com.gds.springbootdemo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 龚道松
 * @Date 2019/5/26 14:37
 * @Wersion 1.0
 **/
// 全局捕获异常
@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(RuntimeException.class)
 //   @ResponseBody
    public Map<String, Object> resulterr(){

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errorCode", "500");
        result.put("errorMsg", "系统错误");
        return  result;
    }
}
