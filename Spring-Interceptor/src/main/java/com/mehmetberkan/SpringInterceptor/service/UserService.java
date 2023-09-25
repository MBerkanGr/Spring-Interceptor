package com.mehmetberkan.SpringInterceptor.service;

import com.mehmetberkan.SpringInterceptor.context.UserContext;
import com.mehmetberkan.SpringInterceptor.model.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    public User addUser(String name) {
        User user = new User();

        Map<String, String> stringMap = UserContext.getValue();

        user.setId(stringMap.get("userId"));
        user.setNickName(stringMap.get("nickName"));
        user.setName(name);

        System.out.println(user);
        return user;
    }
}
