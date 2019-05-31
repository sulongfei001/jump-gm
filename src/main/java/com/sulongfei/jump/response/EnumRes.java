package com.sulongfei.jump.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class EnumRes implements Serializable {

    private static final long serialVersionUID = -1280398705355998555L;

    private Integer type;

    private String key;

    private String value;
}
