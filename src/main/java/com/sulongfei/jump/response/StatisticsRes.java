package com.sulongfei.jump.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/16 14:52
 * @Version 1.0
 */
@Data
public class StatisticsRes {
    private List<Integer> registerData;
    private List<Integer> chargeData;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private List<Date> xaxisData;

    private Integer registerCount;
    private BigDecimal chargeCount;
    private Integer chargePeople;
}
