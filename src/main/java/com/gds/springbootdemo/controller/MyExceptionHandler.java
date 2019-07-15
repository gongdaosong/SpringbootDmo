package com.gds.springbootdemo.controller;

import com.gds.springbootdemo.exception.UserNotException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 龚道松
 * @Date 2019/7/15 16:08
 * @Version 1.0
 *          自定义异常处理器
 **/

@ControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler(UserNotException.class)
   public String handlerException(Exception e, HttpServletRequest request){
       Map<String, Object> map = new HashMap<String, Object>();
        request.setAttribute("javax.servlet.error.status_code",500);
       map.put("code","user.notexist");
       map.put("message","用户出错了！");
       request.setAttribute("ext",map);
       return "forward/error";
    //   return map;
   }

}
