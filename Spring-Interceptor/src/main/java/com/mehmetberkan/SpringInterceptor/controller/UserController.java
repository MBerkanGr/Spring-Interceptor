package com.mehmetberkan.SpringInterceptor.controller;

import com.mehmetberkan.SpringInterceptor.model.User;
import com.mehmetberkan.SpringInterceptor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public User addUser(@RequestParam("name") String name, HttpSession session) {
        return service.addUser(name, session);
    }

}
