package com.anteater.fengfang.domains;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Clockin {
    private Integer id;
    private String user_id;
    private String clockin_path;
    private String clockin_time;
    private String clockin_lng;
    private String clockin_lat;

    @Override
    public String toString() {
        return "Clockin{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", clockin_path='" + clockin_path + '\'' +
                ", clockin_time='" + clockin_time + '\'' +
                ", clockin_lng='" + clockin_lng + '\'' +
                ", clockin_lat='" + clockin_lat + '\'' +
                '}';
    }
}
