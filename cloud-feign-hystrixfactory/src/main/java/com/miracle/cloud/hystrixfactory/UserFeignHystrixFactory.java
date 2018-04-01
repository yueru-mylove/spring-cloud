package com.miracle.cloud.hystrixfactory;

import com.miracle.cloud.bean.User;
import com.miracle.cloud.feign.UserFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFeignHystrixFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeignHystrixFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {

        LOGGER.info("fallback : The exception is : {}", cause.getMessage());

        return new UserFeignClientFactory() {
            @Override
            public User getUserById(Integer id) {
                User user = new User();
                user.setUsername("test hystrxFactory ... ...");
                return user;
            }
        };
    }
}
