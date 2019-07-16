package com.gds.springbootdemo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author 龚道松
 * @Date 2019/7/16 10:35
 * @Version 1.0
 **/
public class myFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("myFilter process......");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
