package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.RankPrizeDTO;
import com.sulongfei.jump.response.Response;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/10 16:07
 * @Version 1.0
 */
public interface PrizeService {
    Response createRankPrize(RankPrizeDTO dto);

    Response rankPrizeList(Long remoteClubId);
}
