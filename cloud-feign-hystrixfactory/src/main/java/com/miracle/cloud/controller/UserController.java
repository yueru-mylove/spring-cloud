package com.miracle.cloud.controller;


import com.miracle.cloud.bean.User;
import com.miracle.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {

        return userFeignClient.getUserById(id);
    }
}
