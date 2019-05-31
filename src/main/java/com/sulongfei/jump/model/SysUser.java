package com.sulongfei.jump.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends Model {
    private static final long serialVersionUID = 479725769209354278L;

    private String sysName;

    private String username;

    private String password;

    private String avatar;

    private String createUser;


}