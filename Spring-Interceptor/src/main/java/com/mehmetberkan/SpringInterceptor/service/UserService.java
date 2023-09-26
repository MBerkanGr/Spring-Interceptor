package com.mehmetberkan.SpringInterceptor.service;

import com.mehmetberkan.SpringInterceptor.context.UserContext;
import com.mehmetberkan.SpringInterceptor.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class UserService {

    public User addUser(String name, HttpSession session) {
        User user = new User();

        Map<String, String> stringMap = UserContext.getValue();

        user.setId(stringMap.get("userId"));
        user.setNickName(stringMap.get("nickName"));
        user.setName(name);

        System.out.println(user);
        UserContext.removeThreadLocal();

        System.out.println("Dialect : " + session.getAttribute("dialect"));
        System.out.println("Ip : " + session.getAttribute("ip"));
        System.out.println("Login Time :" + session.getAttribute("loginTime"));

        long maxInactiveInterval = 10 * 60;
        long inactiveDuration = (System.currentTimeMillis() - session.getLastAccessedTime()) / 1000;

        if(maxInactiveInterval - inactiveDuration < 0L) {
            session.invalidate();
        }

        return user;
    }
}
