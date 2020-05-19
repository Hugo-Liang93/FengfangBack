package com.anteater.fengfang.mapper;

import com.anteater.fengfang.domains.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    Permission getPermissionsByRoleID(Integer role_id);
    List<Permission> getAllPermission();
}
