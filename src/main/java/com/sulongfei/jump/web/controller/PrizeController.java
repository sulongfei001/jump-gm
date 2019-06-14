package com.sulongfei.jump.web.controller;

import com.sulongfei.jump.dto.RankPrizeDTO;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/10 16:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/prize")
public class PrizeController {
    @Autowired
    private PrizeService prizeService;

    @PostMapping("/rank/create")
    public Response createRankPrize(@RequestBody RankPrizeDTO dto) {
        return prizeService.createRankPrize(dto);
    }

    @PostMapping("/rank/list")
    public Response rankPrizeList(@RequestParam Long remoteClubId) {
        return prizeService.rankPrizeList(remoteClubId);
    }
}
