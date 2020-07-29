package com.anteater.fengfang.controller;

import com.anteater.fengfang.domains.Clockin;
import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.domains.auth.LoginInfo;
import com.anteater.fengfang.mapper.AuthMapper;
import com.anteater.fengfang.service.AuthService;
import com.anteater.fengfang.service.UserService;
import com.anteater.fengfang.utils.JwtTokenUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private static Logger logger= Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/user-management/users",method = RequestMethod.GET)
    @ResponseBody
    public List<User> userList(String userId,String roleId){
        List<User> userList = userService.getUserList(userId,roleId);
        return userList;
    }

    @RequestMapping(value = "/api/user-management/userAccountInfo",method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateUserAccountInfo (@RequestBody  User user){
        userService.updateUserAccountInfo(user);
        return null;
    }

    @RequestMapping(value = "api/user-management/userUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateUserInfo (@RequestBody  User user){
        userService.updateUserInfo(user);
        return null;
    }

    @RequestMapping(value = "api/user-management/userUserSocialInfo",method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateUserSocialInfo (@RequestBody  User user){
        userService.updateUserSocialInfo(user);
        return null;
    }

    @RequestMapping(value = "/api/user-management/users/{user_id}",method = RequestMethod.GET)
    @ResponseBody
    public User user(@PathVariable String user_id){
        return userService.getUserById(user_id);
    }





    @RequestMapping(value = "api/user-management/user-add",method = RequestMethod.POST)
    @ResponseBody
    public Boolean addUser (@RequestBody  User user){
        logger.info(user.toString());
        return userService.addUser(user);
    }

    @RequestMapping(value = "api/user-management/user-del/{user_id}",method = RequestMethod.GET)
    @ResponseBody
    public Boolean delUser (@PathVariable  String  user_id){
        return userService.delUser(user_id);
    }

    @RequestMapping(value = "api/filter/get-roles",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getRoles (){
        return userService.getRoles();
    }

    @RequestMapping(value = "api/filter/get-companys",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getCompanys (){
        return userService.getCompanys();
    }

    @RequestMapping(value = "api/filter/get-depts",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getDepts (){
        return userService.getDepts();
    }



}
