package com.miracle.cloud.controller;

import com.miracle.cloud.bean.User;
import com.miracle.cloud.feign.FeignProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private FeignProductClient feignProductClient;

    @GetMapping("/users")
    public List<User> getUsers() {

        return feignProductClient.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserByOne(@PathVariable("id") Integer id) {

        return feignProductClient.getUserById(id);
    }

}
