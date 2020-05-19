package com.anteater.fengfang.mapper;

import com.anteater.fengfang.domains.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
    Integer addActivity(Activity activity);
    List<Activity> getActivityByCompany(String company);
}
