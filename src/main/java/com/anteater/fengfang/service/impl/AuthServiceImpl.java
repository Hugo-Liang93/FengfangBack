package com.anteater.fengfang.service.impl;

import com.anteater.fengfang.domains.Permission;
import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.domains.auth.CheckResult;
import com.anteater.fengfang.domains.auth.LoginInfo;
import com.anteater.fengfang.domains.response.ResBody;
import com.anteater.fengfang.mapper.AuthMapper;
import com.anteater.fengfang.mapper.PermissionMapper;
import com.anteater.fengfang.service.AuthService;
import com.anteater.fengfang.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;
    @Autowired
    private PermissionMapper permissionMapper;

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

    @Override
    public List<Permission> getPermissions() {
        return permissionMapper.getAllPermission();
    }

    @Override
    public ResBody changePass(Map<String, String> map) {
        ResBody resBody = new ResBody();
        if (authMapper.checkPass(map.get("user_id"),map.get("oldPass"))){
            resBody.setStatus(authMapper.updatePass(map.get("newPass"),map.get("user_id")));
            return resBody;
        } else {
            resBody.setStatus(false);
            resBody.setErrorMsg("密码不正确");
            return resBody;
        }

    }
}
