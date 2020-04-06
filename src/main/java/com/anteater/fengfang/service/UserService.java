package com.anteater.fengfang.service;

import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.domains.auth.LoginInfo;

import java.util.List;

public interface UserService {
    public void logout();
    List<User> getUserList();
}
