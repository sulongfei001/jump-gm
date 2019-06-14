package com.sulongfei.jump.service.impl;

import com.google.common.collect.Lists;
import com.sulongfei.jump.dto.Prize;
import com.sulongfei.jump.dto.RankPrizeDTO;
import com.sulongfei.jump.mapper.RankPrizeMapper;
import com.sulongfei.jump.model.RankPrize;
import com.sulongfei.jump.response.RankPrizeRes;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.service.PrizeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/10 16:08
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class PrizeServiceImpl implements PrizeService {
    @Autowired
    private RankPrizeMapper rankPrizeMapper;

    @Override
    @Transactional(readOnly = false)
    public Response createRankPrize(RankPrizeDTO dto) {
        Long remoteClubId = dto.getRemoteClubId();
        if (dto.getPrizeList().size() > 0) {
            rankPrizeMapper.deleteByClubId(remoteClubId);
        }
        for (int i = 0; i < dto.getPrizeList().size(); i++) {
            Prize prize = dto.getPrizeList().get(i);
            RankPrize rankPrize = new RankPrize(remoteClubId, i, prize.getRemoteGoodsId(), prize.getGoodsNum());
            rankPrizeMapper.insertSelective(rankPrize);
        }
        return new Response();
    }

    @Override
    public Response rankPrizeList(Long remoteClubId) {
        List<RankPrize> list = rankPrizeMapper.selectByClubId(remoteClubId);
        List<Prize> prizes = Lists.newArrayList();
        list.forEach(rankPrize -> {
            Prize prize = new Prize();
            BeanUtils.copyProperties(rankPrize, prize);
            prizes.add(prize);
        });
        RankPrizeRes data = new RankPrizeRes();
        data.setRemoteClubId(remoteClubId);
        data.setPrizeList(prizes);
        return new Response(data);
    }
}
