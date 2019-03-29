package com.demo.firt.web;

import com.demo.firt.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器");
        //request获取域空间
        HttpSession session = request.getSession();
        //域空间中取得loginUser，并传递给user对象
        User user = (User) session.getAttribute("loginUser");
        //判断user是否为空
        if(user != null){
            //已登录
            return true;
        }else {
            //未登录，不允许访问main页面
            request.setAttribute("loginErr","您没有登录，不能访问页面");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
    }
}
