package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.SpreadGoodsDTO;
import com.sulongfei.jump.response.Response;

public interface GoodsService {
    Response synchronizeGoodsList();

    Response createSpreadGoods(SpreadGoodsDTO goodsDTO);

    Response spreadGoodsList(SpreadGoodsDTO goodsDTO);

    Response localGoodsList(SpreadGoodsDTO goodsDTO);

    Response localGoodsAll(SpreadGoodsDTO goodsDTO);

    Response getSpreadGoods(long id);

    Response updateSpreadGoods(SpreadGoodsDTO dto);
}
