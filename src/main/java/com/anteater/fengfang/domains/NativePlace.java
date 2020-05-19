package com.anteater.fengfang.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class NativePlace {
    private String user_id;
    private String native_province;
    private String native_city;
    private String native_address;
}
