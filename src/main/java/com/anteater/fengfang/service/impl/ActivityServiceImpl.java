package com.anteater.fengfang.service.impl;

import com.anteater.fengfang.domains.Activity;
import com.anteater.fengfang.mapper.ActivityMapper;
import com.anteater.fengfang.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper acitivityMapper;
    @Override
    public void addActivity(Activity activity) {
        acitivityMapper.addActivity(activity);
    }

    @Override
    public List<Activity> getActivityByCompany(String company) {
        return null;
    }
}
