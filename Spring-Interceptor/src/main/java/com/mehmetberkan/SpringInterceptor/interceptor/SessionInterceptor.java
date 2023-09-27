package com.mehmetberkan.SpringInterceptor.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        checkSessionInactiveDuration(request.getSession());
        checkSessionMaxActiveDuration(request.getSession());

        request.getSession().setAttribute("dialect", request.getHeader("dialect"));
        request.getSession().setAttribute("ip", request.getHeader("ip"));
        request.getSession().setAttribute("loginTime", String.valueOf(new Date()));

        return true;
    }

    private void checkSessionInactiveDuration(HttpSession session) {
        long maxInactiveInterval = 2 * 60;
        long inactiveDuration = (System.currentTimeMillis() - session.getLastAccessedTime()) / 1000;

        if(maxInactiveInterval - inactiveDuration < 0L) {
            session.invalidate();
        }
    }

    private void checkSessionMaxActiveDuration(HttpSession session) {
        long maxActiveInterval = 10 * 60;
        long inactiveDuration = (System.currentTimeMillis() - session.getCreationTime()) / 1000;

        if(maxActiveInterval - inactiveDuration < 0L) {
            session.invalidate();
        }
    }
}
