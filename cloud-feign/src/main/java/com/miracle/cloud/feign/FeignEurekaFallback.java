package com.miracle.cloud.feign;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

@Component
public class FeignEurekaFallback implements FeignEurekaClient{
    @Override
    public String findServiceByServiceName(String service_name) {
        return "this is the feigneureka fallback ... ... ";
    }
}
