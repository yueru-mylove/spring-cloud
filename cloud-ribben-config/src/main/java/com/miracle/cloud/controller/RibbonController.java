package com.miracle.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/say")
    public String say() {

        ServiceInstance instance = loadBalancerClient.choose("cloud-product2");
        System.out.println(instance.getHost() + "=======" + instance.getPort());
        return "this the ribbon yml loadbalance test ... ...";
    }
}
