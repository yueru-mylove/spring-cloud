package com.miracle.cloud.feign;


import com.miracle.cloud.config.FeignEurekaConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cloud-eureka-erver", url = "http://localhost:8761/", configuration = FeignEurekaConfiguration.class, fallback = FeignEurekaFallback.class)
public interface FeignEurekaClient {

    @RequestMapping(value = "/eureka/apps/{service_name}", method = RequestMethod.GET)
    public String findServiceByServiceName(@PathVariable("service_name") String service_name);
}
