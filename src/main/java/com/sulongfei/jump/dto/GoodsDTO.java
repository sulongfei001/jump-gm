package com.sulongfei.jump.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/24 16:10
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsDTO extends BaseDTO {

    private static final long serialVersionUID = 5842373100692301564L;

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
