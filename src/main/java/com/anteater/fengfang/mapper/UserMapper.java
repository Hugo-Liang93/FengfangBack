package com.anteater.fengfang.mapper;

import com.anteater.fengfang.domains.NativePlace;
import com.anteater.fengfang.domains.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAllUsers();
    User getUserById(String user_id);
    Integer updateUserAccountInfo(User user);

    Integer updateUserInfo(User user);

    Integer updateUserSocialInfo(User user);

    Boolean addUser(User user);

    Boolean addNativePlace(NativePlace nativePlace);

    Boolean delUser(String user_id);
}
