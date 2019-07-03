package com.sulongfei.jump.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/1 10:33
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends BaseDTO {

    private String phoneNumber;
}
