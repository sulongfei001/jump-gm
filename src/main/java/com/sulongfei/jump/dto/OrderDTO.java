package com.sulongfei.jump.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/11 17:27
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDTO extends BaseDTO {
    private Long remoteClubId;
    private Long swOrderId;
    private Byte result;
    private Long userId;
}
