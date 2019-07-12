package com.sulongfei.jump.response;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/11 17:17
 * @Version 1.0
 */
@Data
public class OrderRes {
    private Long id;

    private Long userId;

    private Long orgId;

    private Long productId;

    private Integer productNum;

    private BigDecimal price;

    private Integer ticketNum;

    private Timestamp buyTime;

    private Long swOrderId;

    private Byte result;

    private Byte status;

    private UserRes user;

    private GoodsRes goods;
}
