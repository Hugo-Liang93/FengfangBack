package com.anteater.fengfang.service;

import com.anteater.fengfang.domains.Activity;

import java.util.List;

public interface ActivityService {
    void addActivity(Activity activity);
    Boolean updateActivity(Activity activity);
    List<Activity> getActivityByCompany(String company);

    Boolean deleteActivity(String activityId);
}
