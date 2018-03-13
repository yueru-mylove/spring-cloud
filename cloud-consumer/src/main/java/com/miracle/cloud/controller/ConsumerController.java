package com.miracle.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/say")
    public String say() {

        ServiceInstance instance = loadBalancerClient.choose("cloud-product");
        System.out.println(instance.getHost() + "=========" + instance.getPort());

        ServiceInstance instance1 = loadBalancerClient.choose("cloud-product2");
        System.out.println(instance1.getHost() + "*********" + instance1.getPort());
       /* restTemplate.getForObject("http://cloud-product/say", Void.class);*/
        return "this is the ribbon loadbalance test......";
    }
}
