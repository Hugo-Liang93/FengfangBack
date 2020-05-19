package com.anteater.fengfang.mapper;

import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.domains.auth.LoginInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthMapper {
    User getUserbyLoginInfo(LoginInfo loginInfo);
    Boolean updatePass(String newPass,String user_id);
    Boolean checkPass(String user_id ,String pass);
}
