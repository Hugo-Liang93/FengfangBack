package com.anteater.fengfang.service;

import com.anteater.fengfang.domains.Activity;

import java.util.List;

public interface ActivityService {
    void addActivity(Activity activity);
    List<Activity> getActivityByCompany(String company);
}
