package com.gds.springbootdemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author 龚道松
 * @Date 2019/7/16 11:15
 * @Version 1.0
 **/
public class myListrner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized 应用启动了。。。。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("contextInitialized 应用销毁了。。。。。。");
    }
}
