package com.anteater.fengfang.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Comment {
    private String like_id;
    private Activity activity;
    private User user;
    private String like_comment;
    private String like_comment_date;
    private String flag;
}
