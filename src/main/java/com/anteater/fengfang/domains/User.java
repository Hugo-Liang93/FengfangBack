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
    private String user_phone;
    private String user_birthday;
    private String user_gender;
    private String user_idcard;
    private NativePlace nativePlace;
    private Social social;
    private Permission permission;
    private Clockin clockin;

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_company='" + user_company + '\'' +
                ", user_dept='" + user_dept + '\'' +
                ", user_office='" + user_office + '\'' +
                ", user_hiredate='" + user_hiredate + '\'' +
                ", user_position='" + user_position + '\'' +
                ", user_pic='" + user_pic + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_birthday='" + user_birthday + '\'' +
                ", user_gender='" + user_gender + '\'' +
                ", user_idcard='" + user_idcard + '\'' +
                ", nativePlace=" + nativePlace +
                ", social=" + social +
                ", permission=" + permission +
                ", clockin=" + clockin +
                '}';
    }
}
