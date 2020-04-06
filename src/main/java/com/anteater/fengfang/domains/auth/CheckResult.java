package com.anteater.fengfang.domains.auth;

import io.jsonwebtoken.Claims;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class CheckResult {
    private Claims claims;
    private String errCode;
    private Boolean success;
}
