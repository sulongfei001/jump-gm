package com.sulongfei.jump.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/17 16:46
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SpreadRoomDTO extends BaseDTO {
    private Long roomId;
    private Long remoteClubId;
}
