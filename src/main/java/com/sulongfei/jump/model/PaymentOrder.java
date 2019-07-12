package com.sulongfei.jump.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaymentOrder extends Model {
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

    private SecurityUser user;

    private Goods goods;

}