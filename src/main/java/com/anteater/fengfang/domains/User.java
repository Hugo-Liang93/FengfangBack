package com.anteater.fengfang.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter@Setter@ToString
public class User {
    private String user_id;
    @JsonProperty(value = "name")
    private String user_name;
    private String user_company;
    private String user_dept;
    private String user_office;
    private String user_hiredate;
    private String user_position;
    private String user_pic;
    @JsonProperty(value = "password")
    private String user_password;
    @JsonProperty(value = "email")
    private String user_email;
    private Permisssion permisssion;
    private List<Clockin> clockin;
}
