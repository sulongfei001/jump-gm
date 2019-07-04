package com.sulongfei.jump.response;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/24 17:43
 * @Version 1.0
 */
@Data
public class RecordRes {
    private Long id;

    private Long userId;

    private Long roomId;

    private Long roomType;

    private Integer integral;

    private Boolean isWin;

    private Integer consumeTicket;

    private Timestamp createTime;

    private UserRes user;
}
