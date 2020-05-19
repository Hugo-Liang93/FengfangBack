package com.anteater.fengfang.domains.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter@Setter@Component
public class ResBody {
    private String errorMsg;
    private Integer affectNum;
    private Boolean Status;
}
