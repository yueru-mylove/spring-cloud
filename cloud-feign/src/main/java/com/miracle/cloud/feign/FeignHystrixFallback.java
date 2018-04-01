package com.miracle.cloud.feign;

import com.miracle.cloud.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * 需要将此组件加入Spring容器
 *
 */
@Component
public class FeignHystrixFallback implements FeignProductClient {
    @Override
    public List<User> getUsers() {
        return new ArrayList<>();
    }

    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setUsername("zhangsanlisi");
        return user;
    }
}
