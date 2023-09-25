package com.mehmetberkan.SpringInterceptor.interceptor;

import com.mehmetberkan.SpringInterceptor.context.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        Map<String, String> stringMap = new HashMap<>();

        String nickName = (request.getParameter("name") + new Date().hashCode()).replaceAll("\\s", "");

        stringMap.put("userId", UUID.randomUUID().toString());
        stringMap.put("nickName", nickName);

        UserContext.setValue(stringMap);
        return true;
    }
}
