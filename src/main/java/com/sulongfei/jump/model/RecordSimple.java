package com.sulongfei.jump.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class RecordSimple extends Model {
    private Long id;

    private Long userId;

    private Long roomId;

    private Integer integral;

    private Boolean isWin;

    private Integer consumeTicket;

    private Integer getTicket;

    private Long saleId;

    private Integer saleType;

    private Timestamp createTime;

    private SecurityUser user;

}