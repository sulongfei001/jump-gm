package com.sulongfei.jump.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/19 13:40
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysConfigDTO extends BaseDTO{

    private String key;

    private String value;

}
