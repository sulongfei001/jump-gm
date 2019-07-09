package com.sulongfei.jump.response;

import lombok.Data;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/9 10:57
 * @Version 1.0
 */
@Data
public class TicketRes {
    private Long id;

    private Long userId;

    private Long remoteClubId;

    private String supplierName;

    private Integer num;
}
