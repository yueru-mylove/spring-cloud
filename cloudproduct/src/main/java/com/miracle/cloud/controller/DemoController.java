package com.miracle.cloud.controller;


import com.miracle.cloud.bean.User;
import com.miracle.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {


    @Autowired
    private UserService userService;

    @GetMapping("/say")
    public void say() {

        System.out.println("this is a eureka test ... ... ");
    }


    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
