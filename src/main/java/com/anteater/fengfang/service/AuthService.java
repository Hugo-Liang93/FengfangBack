package com.anteater.fengfang.service;

import com.anteater.fengfang.domains.Permission;
import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.domains.auth.LoginInfo;
import com.anteater.fengfang.domains.response.ResBody;

import java.util.List;
import java.util.Map;

public interface AuthService {
    User login(LoginInfo loginInfo);
    public String genAccessToken(Map<String,Object> claims);
    public void verifyAccessToken(String jwtStr);
    public void renewAccessToken();
    List<Permission> getPermissions();
    ResBody changePass(Map<String,String> map);
}
