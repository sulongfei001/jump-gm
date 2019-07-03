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
public class RecordSimpleRes {
    private Long id;

    private Long userId;

    private String userName;

    private Integer integral;

    private Integer consumeTicket;

    private Timestamp createTime;
}
