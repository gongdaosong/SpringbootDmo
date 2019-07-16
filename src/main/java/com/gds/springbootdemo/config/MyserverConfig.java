package com.gds.springbootdemo.config;

import com.gds.springbootdemo.filter.myFilter;
import com.gds.springbootdemo.listener.myListrner;
import com.gds.springbootdemo.servlet.Myservlet;
import com.sun.org.apache.xml.internal.security.utils.XalanXPathAPI;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.JettyWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ConfigurableWebEnvironment;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Arrays;
import java.util.EventListener;

/**
 * @Author 龚道松
 * @Date 2019/7/16 9:12
 * @Version 1.0
 **/
@Configuration
public class MyserverConfig {

    // 注册三大组件
    @Bean
    public ServletRegistrationBean Myservlet(){
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new Myservlet(),"/Myservlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new myFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/Myservlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<>(new myListrner());
        return registrationBean;
    }
    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(8585);
        return factory;
    }
}
