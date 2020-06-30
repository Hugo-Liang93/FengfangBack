package com.anteater.fengfang.controller;

import com.anteater.fengfang.domains.Permission;
import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.domains.auth.LoginInfo;
import com.anteater.fengfang.domains.response.ResBody;
import com.anteater.fengfang.service.AuthService;
import com.anteater.fengfang.utils.JwtTokenUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AuthController {
    private static Logger logger= Logger.getLogger(AuthController.class);
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/api/auth/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(@RequestBody LoginInfo loginInfo){
        User user = authService.login(loginInfo);
        Map<String,Object> claims =new HashMap<>();
        claims.put("id",loginInfo.getLogin_id());
        Map<String,Object> map =new HashMap<>();
        map.put("userData",user);
        map.put("accessToken", JwtTokenUtils.generatorToken(claims));
        return map;
    }

    @RequestMapping(value = "/api/user-management/permissions",method = RequestMethod.GET)
    @ResponseBody
    public List<Permission> getPermission(){
        return authService.getPermissions();
    }

    @RequestMapping(value = "/api/auth/changePass",method = RequestMethod.POST)
    @ResponseBody
    public ResBody changePass(@RequestBody Map<String,String> map){

        return  authService.changePass(map);
    }

}
