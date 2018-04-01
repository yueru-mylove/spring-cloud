package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableFeignClients
public class FeignHystrixFactoryServer {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixFactoryServer.class, args);
    }

}
