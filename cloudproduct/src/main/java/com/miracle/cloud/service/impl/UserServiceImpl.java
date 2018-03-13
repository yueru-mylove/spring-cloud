package com.miracle.cloud.service.impl;

import com.miracle.cloud.bean.User;
import com.miracle.cloud.bean.UserExample;
import com.miracle.cloud.dao.UserMapper;
import com.miracle.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
