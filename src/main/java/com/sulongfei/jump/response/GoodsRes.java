package com.sulongfei.jump.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/23 19:21
 * @Version 1.0
 */
@Data
public class GoodsRes {

    private Long id;

    private Long remoteGoodsId;

    private Long remoteClubId;

    private String goodsName;

    private Integer goodsNum;

    private BigDecimal goodsPrice;

    private Integer goodsType;

    private String goodsPicture;

    private String detailPicture;

    private Integer remainNum;

    private String goodsText;

}
