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
    public List<User> userList(){
        List<User> userList = userService.getUserList();
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

    @RequestMapping(value = "/api/user/clockin",method = RequestMethod.POST)
    @ResponseBody
    public Boolean clockIn(@RequestBody Clockin clockin){
        logger.info(clockin);
        return userService.clockIn(clockin);
    }

    @RequestMapping(value = "/api/user/clockin/{user_id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Clockin> getClockInList(@PathVariable String user_id){
        return userService.getThisMonthClockInListByUid(user_id);
    }
}
