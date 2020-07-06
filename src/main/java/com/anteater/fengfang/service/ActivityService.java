package com.anteater.fengfang.service;

import com.anteater.fengfang.domains.Activity;
import com.anteater.fengfang.domains.Comment;
import com.anteater.fengfang.domains.User;

import java.util.List;

public interface ActivityService {
    void addActivity(Activity activity);
    Boolean updateActivity(Activity activity);
    List<Activity> getActivityByCompany(String company);

    Boolean deleteActivity(String activityId);
    List<Comment> getCommentByActivityId(String activityId);

    List<User> getLikePostByActivityId(String activityId);

    Boolean changeLinked(String activity_id, String user_id);

    Boolean postMsg(String activity_id, String user_id,String msg);

    List<Comment> getAllComment();
}
