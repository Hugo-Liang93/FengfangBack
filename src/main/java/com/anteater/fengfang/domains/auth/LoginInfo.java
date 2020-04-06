package com.anteater.fengfang.domains.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LoginInfo {
    @JsonProperty(value = "email")
    private String login_id;
    @JsonProperty(value = "password")
    private String login_password;
}
