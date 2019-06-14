package com.sulongfei.jump.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RankPrize extends Model {

    private static final long serialVersionUID = 1506545129832804642L;

    private Long id;

    private Long remoteClubId;

    private Integer sequence;

    private Long remoteGoodsId;

    private Integer goodsNum;

    public RankPrize() {
    }

    public RankPrize(Long remoteClubId, Integer sequence, Long remoteGoodsId, Integer goodsNum) {
        this.remoteClubId = remoteClubId;
        this.sequence = sequence;
        this.remoteGoodsId = remoteGoodsId;
        this.goodsNum = goodsNum;
    }
}