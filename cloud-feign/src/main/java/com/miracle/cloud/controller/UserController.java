package com.miracle.cloud.controller;

import com.miracle.cloud.bean.User;
import com.miracle.cloud.feign.FeignEurekaClient;
import com.miracle.cloud.feign.FeignProductClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private FeignProductClient feignProductClient;

    @Autowired
    private FeignEurekaClient feignEurekaClient;

    @GetMapping("/users")
    @HystrixCommand(fallbackMethod = "fallbackGetUsers")
    public List<User> getUsers() {

        return feignProductClient.getUsers();
    }


    public List<User> fallbackGetUsers() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        user.setUsername("zhangsna");
        users.add(user);
        return users;
    }

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "getOneUser")
    public User getUserByOne(@PathVariable("id") Integer id) {

        return feignProductClient.getUserById(id);
    }

    public User getOneUser(Integer id) {
        return new User();
    }


    @GetMapping("/info/{service_name}")
    public String getServiceInfo(@PathVariable("service_name") String service_name) {
        return feignEurekaClient.findServiceByServiceName(service_name);
    }
}
