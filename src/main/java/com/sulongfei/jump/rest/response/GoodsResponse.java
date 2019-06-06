package com.sulongfei.jump.rest.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/5 14:28
 * @Version 1.0
 */
@Data
public class GoodsResponse {
    private Long goodsId;
    private String name;
    private String logo;
    private String detailLogo;
    private Long orgId;
    private Integer stockNum;
    private BigDecimal price;
}
