package com.sulongfei.jump.response;

import lombok.Data;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/19 10:36
 * @Version 1.0
 */
@Data
public class SysConfigRes {
    private Long id;

    private String key;

    private String value;

    private String remark;

    private Byte type;

}
