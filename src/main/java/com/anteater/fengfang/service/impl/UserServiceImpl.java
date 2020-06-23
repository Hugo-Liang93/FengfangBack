package com.anteater.fengfang.service.impl;

import com.anteater.fengfang.domains.Clockin;
import com.anteater.fengfang.domains.NativePlace;
import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.domains.auth.LoginInfo;
import com.anteater.fengfang.mapper.AuthMapper;
import com.anteater.fengfang.mapper.ClockInMapper;
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
    @Autowired
    private ClockInMapper clockInMapper;

    @Override
    public void logout() {

    }

    @Override
    public List<User> getUserList() {
        return userMapper.getAllUsers();
    }

    @Override
    public User getUserById(String user_id) {
        return userMapper.getUserById(user_id);
    }

    @Override
    public Boolean updateUserAccountInfo(User user) {
        return userMapper.updateUserAccountInfo(user)>0?true:false;
    }

    @Override
    public Boolean updateUserInfo(User user) {
        return userMapper.updateUserInfo(user)>0?true:false;
    }

    @Override
    public Boolean updateUserSocialInfo(User user) {
        return userMapper.updateUserSocialInfo(user)>0?true:false;
    }

    @Override
    public Boolean clockIn(Clockin clockin) {
        return clockInMapper.insertClockIn(clockin)>0?true:false;
    }

    @Override
    public List<Clockin> getThisMonthClockInListByUid(String user_id) {
        return clockInMapper.getThisMonthClockInListByUid(user_id);
    }

    @Override
    public Boolean addUser(User user) {
        user.getNativePlace().setUser_id(user.getUser_id());
        return userMapper.addUser(user) && userMapper.addNativePlace(user.getNativePlace());
    }

    @Override
    public Boolean delUser(String user_id) {
        return userMapper.delUser(user_id);
    }


}
