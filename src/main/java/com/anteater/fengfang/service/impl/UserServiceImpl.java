package com.anteater.fengfang.service.impl;

import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.domains.auth.LoginInfo;
import com.anteater.fengfang.mapper.AuthMapper;
import com.anteater.fengfang.mapper.UserMapper;
import com.anteater.fengfang.service.AuthService;
import com.anteater.fengfang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void logout() {

    }

    @Override
    public List<User> getUserList() {
        return userMapper.getAllUsers();
    }
}
