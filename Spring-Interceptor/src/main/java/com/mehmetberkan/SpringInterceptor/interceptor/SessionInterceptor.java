package com.mehmetberkan.SpringInterceptor.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.getSession().setAttribute("dialect", request.getHeader("dialect"));
        request.getSession().setAttribute("ip", request.getHeader("ip"));
        request.getSession().setAttribute("loginTime", String.valueOf(new Date()));

        return true;
    }
}
