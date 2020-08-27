package com.anteater.fengfang.service.impl;

import com.anteater.fengfang.controller.AuthController;
import com.anteater.fengfang.domains.Activity;
import com.anteater.fengfang.domains.Comment;
import com.anteater.fengfang.domains.User;
import com.anteater.fengfang.mapper.ActivityMapper;
import com.anteater.fengfang.service.ActivityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    private static Logger logger= Logger.getLogger(ActivityServiceImpl.class);
    @Autowired
    private ActivityMapper acitivityMapper;
    @Override
    public void addActivity(Activity activity) {
        acitivityMapper.addActivity(activity);
    }

    @Override
    public Boolean updateActivity(Activity activity) {
        return acitivityMapper.updateActivity(activity);
    }

    @Override
    public List<Activity> getActivityByCompany(String company) {
        return acitivityMapper.getActivityByCompany(company);
    }

    @Override
    public Boolean deleteActivity(String activityId) {
        return acitivityMapper.deleteActivityById(activityId);
    }

    @Override
    public List<Comment> getCommentByActivityId(String activityId) {
        return acitivityMapper.getCommentByActivityId(activityId);
    }

    @Override
    public List<User> getLikePostByActivityId(String activityId) {
        return acitivityMapper.getLikePost(activityId);
    }

    @Override
    public Boolean changeLinked(String activity_id, String user_id) {
        List<User> users = acitivityMapper.getLikePost(activity_id);
        if (users != null) {
            for(User user: users){
                if(user.getUser_id().equals(user_id)){
                    return acitivityMapper.deleteLikeFlag(activity_id,user_id);
                }
            }
        }
        return acitivityMapper.addLikeFlag(activity_id,user_id);
    }

    @Override
    public Boolean postMsg(String activity_id, String user_id, String msg) {
        return acitivityMapper.postMsg(activity_id,user_id,msg);
    }

    @Override
    public List<Comment> getAllComment() {
        return acitivityMapper.getAllComment();
    }

    @Override
    public Boolean updateCommentStatus(String ls, String type) {
        return acitivityMapper.updateCommentFlag(ls,type);
    }

    @Override
    public Boolean delComments(String ls) {
        return acitivityMapper.delComments(ls.split(","));
    }

    @Override
    public Boolean toTop(String activityId) {
        return acitivityMapper.toTop(activityId);
    }
}
