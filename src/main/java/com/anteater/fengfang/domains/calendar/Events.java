package com.anteater.fengfang.domains.calendar;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Events {
    private Integer id;
    private String user_id;
    private String title;
    private String url;
    private String startDate;
    private String endDate;
    private String classes;
    private String label;
    private String style;
}
