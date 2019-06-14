package com.sulongfei.jump.response;

import com.sulongfei.jump.dto.Prize;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/10 16:09
 * @Version 1.0
 */
@Data
public class RankPrizeRes implements Serializable {

    private static final long serialVersionUID = 3055778006592378816L;

    private Long remoteClubId;
    private List<Prize> prizeList;
}
