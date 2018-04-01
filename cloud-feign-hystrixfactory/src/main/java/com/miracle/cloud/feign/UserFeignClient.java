package com.miracle.cloud.feign;

import com.miracle.cloud.bean.User;
import com.miracle.cloud.configuration.UserFeignConfig;
import com.miracle.cloud.hystrixfactory.UserFeignHystrixFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cloud-product", fallbackFactory = UserFeignHystrixFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer id);

}
