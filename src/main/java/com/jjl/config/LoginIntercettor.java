package com.jjl.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntercettor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object session1 = session.getAttribute("sessino");
        if(session1!=null){
            return true;
        }else {
            request.setAttribute("msg","没有登陆请先登陆");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
    }
}
