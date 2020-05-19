package com.anteater.fengfang.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Permission {
    private Integer role_id;
    private String role_name;
    private String role_name_en;
    private Boolean active_post;
    private Boolean active_del;
    private Boolean active_check;
    private Boolean active_modify;
    private Boolean active_search;
    private Boolean user_add;
    private Boolean user_del;
    private Boolean user_search;
    private Boolean user_modify;
    private Boolean clockin_export;
    private Boolean clockin_del;
    private Boolean clockin_search;
    private Boolean clockin_modify;
    private Boolean schedule_add;
    private Boolean schedule_del;
    private Boolean schedule_search;
    private Boolean schedule_modify;
}
