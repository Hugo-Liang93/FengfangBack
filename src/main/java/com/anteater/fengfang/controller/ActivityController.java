package com.anteater.fengfang.controller;

import com.anteater.fengfang.domains.Activity;
import com.anteater.fengfang.service.ActivityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ActivityController {
    private static Logger logger= Logger.getLogger(ActivityController.class);
    @Autowired
    private ActivityService activityService;

    @RequestMapping(value="/api/Activity/saveInfo")
    @ResponseBody
    public Activity saveActivity(@RequestBody Activity activity){
        logger.info(activity);
        activityService.addActivity(activity);
        return activity;
    }


    @RequestMapping(value="api/Activity/getActivityByCompany")
    public List<Activity> getActivity(String Company){
        logger.info(Company);
        return null;
    }
}
