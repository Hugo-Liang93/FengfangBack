package com.anteater.fengfang.service;

import com.anteater.fengfang.domains.Clockin;
import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.domains.auth.LoginInfo;

import java.util.List;

public interface UserService {
    public void logout();
    List<User> getUserList();
    User getUserById(String user_id);
    Boolean updateUserAccountInfo(User user);
    Boolean updateUserInfo(User user);
    Boolean updateUserSocialInfo(User user);

    Boolean clockIn(Clockin clockin);

    List<Clockin> getThisMonthClockInListByUid(String user_id);

    Boolean addUser(User user);

    Boolean delUser(String user_id);
}
