package com.anteater.fengfang.mapper;

import com.anteater.fengfang.domains.Activity;
import com.anteater.fengfang.domains.Comment;
import com.anteater.fengfang.domains.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
    Integer addActivity(Activity activity);
    List<Activity> getActivityByCompany(String company);
    Boolean updateActivity(Activity activity);

    Boolean deleteActivityById(String activityId);

    List<Comment> getCommentByActivityId(String activityId);

    List<User> getLikePost(String activityId);

    Boolean deleteLikeFlag(String activity_id, String user_id);

    Boolean addLikeFlag(String activity_id, String user_id);

    Boolean postMsg(String activity_id, String user_id,String msg);

    List<Comment> getAllComment();

    Boolean updateCommentFlag(String ls,String type);

    Boolean delComments(String[] deleteString);
}
