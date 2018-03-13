package com.miracle.cloud.service;

import com.miracle.cloud.bean.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User getUserById(Integer id);


}
