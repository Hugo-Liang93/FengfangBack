package com.anteater.fengfang.controller;

import com.anteater.fengfang.domains.Activity;
import com.anteater.fengfang.domains.Comment;
import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.service.ActivityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ActivityController {
    private static Logger logger= Logger.getLogger(ActivityController.class);
    @Autowired
    private ActivityService activityService;

    @RequestMapping(value="/api/Activity/saveInfo")
    @ResponseBody
    public Activity saveActivity(@RequestBody Activity activity){
        activityService.addActivity(activity);
        return activity;
    }

    @RequestMapping(value="/api/Activity/updateInfo")
    @ResponseBody
    public Boolean updateActivity(@RequestBody Activity activity){
        logger.info(activity);
        return activityService.updateActivity(activity);
    }

    @RequestMapping(value="/api/Activity/deleteInfo")
    @ResponseBody
    public Boolean deleteActivity(@RequestBody String  activityId){
        logger.info(activityId);
        return activityService.deleteActivity(activityId);
    }



    @RequestMapping(value="api/Activity/getActivityByCompany")
    @ResponseBody
    public List<Activity> getActivity(@RequestBody String company){
        return activityService.getActivityByCompany(company);
    }

    @RequestMapping(value="api/Activity/api/Activity/listActivity")
    public List<Activity> listActivity(){
        return null;
    }

    @RequestMapping(value="api/Activity/comment/{activity_id}")
    @ResponseBody
    public List<Comment> getCommentByActivityId(@PathVariable String activity_id){
        return activityService.getCommentByActivityId(activity_id);
    }

    @RequestMapping(value="api/Activity/likepost/{activity_id}")
    @ResponseBody
    public List<User> getLikePostByActivityId(@PathVariable String activity_id){
        return activityService.getLikePostByActivityId(activity_id);
    }

    @RequestMapping(value="api/Activity/changelinked/{activity_id}/{userId}")
    @ResponseBody
    public Boolean changeLinked(@PathVariable String activity_id,@PathVariable String userId){
        return activityService.changeLinked(activity_id,userId);
    }

    @RequestMapping(value="api/Activity/postComment/{activity_id}/{userId}")
    @ResponseBody
    public Boolean postComment(@PathVariable String activity_id,@PathVariable String userId,@RequestBody Map<String,String> map){
        logger.info(activity_id + "  " + userId + " "+ map.get("comment") );
        return activityService.postMsg(activity_id,userId,map.get("comment"));
    }

    @RequestMapping(value="api/Activity/getComments")
    @ResponseBody
    public List<Comment> getAllComment(){
        return activityService.getAllComment();
    }
}
