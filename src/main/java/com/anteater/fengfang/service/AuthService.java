package com.anteater.fengfang.service;

import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.domains.auth.LoginInfo;

import java.util.Map;

public interface AuthService {
    User login(LoginInfo loginInfo);
    public String genAccessToken(Map<String,Object> claims);
    public void verifyAccessToken(String jwtStr);
    public void renewAccessToken();
}
