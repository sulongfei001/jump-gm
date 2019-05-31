package com.sulongfei.jump.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/27 11:55
 * @Version 1.0
 */
@Data
public class SpreadGoodsRes implements Serializable {

    private static final long serialVersionUID = -4003437270082575448L;

    private Long id;

    private Long remoteClubId;

    private Long remoteGoodsId;

    private String goodsName;

    private Integer goodsNum;

    private BigDecimal goodsPrice;

    private String goodsPicture;

    private String goodsText;

    private Integer prizeProbability;

    private Integer premiumProportion;

    private String picture1;

    private String picture2;

    private String picture3;

    private String picture4;

}
