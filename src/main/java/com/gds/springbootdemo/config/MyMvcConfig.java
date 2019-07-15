package com.gds.springbootdemo.config;

import com.gds.springbootdemo.component.LoginHandInterceptor;
import com.gds.springbootdemo.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Locale;

/**
 * @Author 龚道松
 * @Date 2019/7/13 11:45
 * @Version 1.0
 **/

/**
 * 配置类
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送 /com.gds.springbootdemo 请求，来到 success
        registry.addViewController("/com.gds.springbootdemo").setViewName("success");
    }

    @Bean
    public WebMvcConfigurerAdapter WebMvcConfigurerAdapter(){

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // 浏览器发送 /com.gds.springbootdemo 请求，来到 success
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 静态资源 ： *.css *.js
                // Springboot 已经做好了静态资源的映射
               /* registry.addInterceptor(new LoginHandInterceptor()).addPathPatterns("/*")
                        .excludePathPatterns("/index.html","/","/user/login");*/
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
