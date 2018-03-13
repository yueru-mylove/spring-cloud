package com.miracle.cloud.feign;


import com.miracle.cloud.bean.User;
import com.miracle.cloud.config.CustomizedFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "cloud-product2", configuration = CustomizedFeignConfiguration.class)
public interface FeignProductClient {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<User> getUsers();

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User getUserById(@PathVariable("id") Integer id);
}
