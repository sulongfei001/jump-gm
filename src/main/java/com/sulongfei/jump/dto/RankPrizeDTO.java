package com.sulongfei.jump.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/10 16:09
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RankPrizeDTO extends BaseDTO {

    private static final long serialVersionUID = 3055778006592378816L;

    private Long remoteClubId ;
    private List<Prize> prizeList;
}
