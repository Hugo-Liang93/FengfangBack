package com.anteater.fengfang.service.impl;

import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.domains.auth.CheckResult;
import com.anteater.fengfang.domains.auth.LoginInfo;
import com.anteater.fengfang.mapper.AuthMapper;
import com.anteater.fengfang.service.AuthService;
import com.anteater.fengfang.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;

    @Override
    public User login(LoginInfo loginInfo) {
        return authMapper.getUserbyLoginInfo(loginInfo);
    }

    @Override
    public String genAccessToken(Map<String,Object> claims) {
        return JwtTokenUtils.generatorToken(claims);
    }

    @Override
    public void verifyAccessToken(String jwtStr) {
        CheckResult checkResult = JwtTokenUtils.validateJWT(jwtStr);

    }

    @Override
    public void renewAccessToken() {

    }
}
