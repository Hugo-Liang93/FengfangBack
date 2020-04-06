package com.anteater.fengfang.domains;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Clockin {
    private Integer id;
    private String user_id;
    private String clockin_path;
    private String clockin_time;
}
