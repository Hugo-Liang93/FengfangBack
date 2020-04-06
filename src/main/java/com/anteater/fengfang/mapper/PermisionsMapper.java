package com.anteater.fengfang.mapper;

import com.anteater.fengfang.domains.Permisssion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PermisionsMapper {
    Permisssion getPermissionsByRoleID(Integer role_id);
}
