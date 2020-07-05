package com.anteater.fengfang.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Activity {
    private String id;
    private String title;
    private String content;
    private String startDate;
    private String endDate;
    private String owner;
    private String company;
    private User user;
}
