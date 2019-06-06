package com.sulongfei.jump.rest.request;

import lombok.Data;

import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/5 14:27
 * @Version 1.0
 */
@Data
public class GoodsRequest {
    private Long gameId;
    private List<Long> goodsIds;

    public GoodsRequest(Long gameId, List<Long> goodsIds) {
        this.gameId = gameId;
        this.goodsIds = goodsIds;
    }
}
