package com.anteater.fengfang.domains.calendar;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class EventLabel {
    private Integer id;
    private String label_text;
    private String label_value;
    private String label_color;
}
