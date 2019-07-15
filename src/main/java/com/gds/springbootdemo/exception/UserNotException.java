package com.gds.springbootdemo.exception;

/**
 * @Author 龚道松
 * @Date 2019/7/15 15:48
 * @Version 1.0
 *      自定义异常
 **/
public class UserNotException extends RuntimeException{

    public UserNotException(){
        super("用户不存在！");
    }
}
