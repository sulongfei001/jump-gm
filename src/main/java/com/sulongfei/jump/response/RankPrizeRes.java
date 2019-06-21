package com.sulongfei.jump.response;

import com.sulongfei.jump.dto.Prize;
import lombok.Data;

import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/10 16:09
 * @Version 1.0
 */
@Data
public class RankPrizeRes {

    private Long remoteClubId;
    private List<Prize> prizeList;
}
