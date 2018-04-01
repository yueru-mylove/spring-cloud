package com.miracle.cloud.controller;


import com.miracle.cloud.bean.User;
import com.miracle.cloud.service.UserService;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

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


    @GetMapping("/eureka-info")
    public String serviceUrl() {
        LOGGER.info("the zuul is working with ribbon ... ... ");
        return this.eurekaClient.getNextServerFromEureka("cloud-product", true).getHomePageUrl();
    }


    @GetMapping("/show-info")
    public ServiceInstance showInfo() {

        return this.discoveryClient.getLocalServiceInstance();
    }
}
