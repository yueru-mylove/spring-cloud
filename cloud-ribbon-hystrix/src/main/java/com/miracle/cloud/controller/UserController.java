package com.miracle.cloud.controller;


import com.miracle.cloud.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "fallbackForGetUser")
    public User getUserById(@PathVariable("id") Integer id) {

        return restTemplate.getForObject("http://cloud-product/user/" + id, User.class);
    }

    public User fallbackForGetUser(Integer id) {

        return new User();
    }
}
