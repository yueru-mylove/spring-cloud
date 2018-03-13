package com.miracle.cloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @GetMapping("/say")
    public void say() {

        System.out.println("this is a eureka test ... ... ");
    }

}
