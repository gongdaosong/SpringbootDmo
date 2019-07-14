package com.gds.springbootdemo.component;

/**
 * @Author 龚道松
 * @Date 2019/7/13 20:35
 * @Version 1.0
 **/

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查
 */
public class LoginHandInterceptor implements HandlerInterceptor {
    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取到session中的值
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null){
            // 未登录 返回登录页
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            // 已登录 放行
            return true;
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
