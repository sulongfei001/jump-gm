package com.sulongfei.jump.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/24 14:24
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoomSimpleDTO extends BaseDTO {

    private Long remoteClubId;

    private Timestamp startTime;

    private Timestamp endTime;

    private Timestamp createTime;

    private Boolean hidden;

    private Integer sequence;

    private Long remoteGoodsId;

    private String goodsName;

    private Integer goodsNum;

    private String goodsPicture;

    private String goodsText;

    private Integer ticketNum;

    private Integer prizeProbability;

    private Integer premiumProportion;

    private String picture1;

    private String picture2;

    private String picture3;

    private String picture4;
}
