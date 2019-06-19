package com.sulongfei.jump.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoomSpread extends Model {
    private Long id;

    private Long remoteClubId;

    private Long createUserId;

    private String password;

    private Long spreadGoodsId;

    private Integer ticketNum;

    private Integer joinNum;

    private Integer partakeNum;

    private Long winRecordId;

    private Integer winNum;

    private Byte status;

    private Timestamp createTime;

    private SpreadGoods spreadGoods;

}