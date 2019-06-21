package com.sulongfei.jump.response;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/17 16:51
 * @Version 1.0
 */
@Data
public class RoomSpreadRes {

    private Long id;

    private String password;

    private Integer ticketNum;

    private Integer joinNum;

    private Integer partakeNum;

    private Integer winNum;

    private Byte status;

    private Timestamp createTime;

    private Timestamp winTime;

    private SpreadGoodsRes spreadGoods;

    private UserRes user;
}
