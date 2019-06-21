package com.sulongfei.jump.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class EnumRes {

    private String key;
    private Integer type;
    private String value;

    public EnumRes(String key, Integer type, String value) {
        this.key = key;
        this.type = type;
        this.value = value;
    }
}
