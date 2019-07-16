package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.GoodsDTO;
import com.sulongfei.jump.response.Response;

public interface GoodsService {
    Response synchronizeGoodsList();

    Response createSpreadGoods(GoodsDTO goodsDTO);

    Response spreadGoodsList(GoodsDTO goodsDTO);

    Response localGoodsList(GoodsDTO goodsDTO);

    Response localGoodsAll(GoodsDTO goodsDTO);

    Response getSpreadGoods(long id);

    Response updateSpreadGoods(GoodsDTO dto);

    Response updateGoods(GoodsDTO dto);
}
