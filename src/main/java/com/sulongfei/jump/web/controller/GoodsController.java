package com.sulongfei.jump.web.controller;

import com.sulongfei.jump.dto.GoodsDTO;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/23 19:09
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping("/local/list")
    public Response localGoodsList(GoodsDTO dto) {
        return goodsService.localGoodsList(dto);
    }

    @PostMapping("/local/all")
    public Response localGoodsAll(GoodsDTO dto) {
        return goodsService.localGoodsAll(dto);
    }

    @PostMapping("/synchronize")
    public Response synchronizeClubList() {
        return goodsService.synchronizeGoodsList();
    }

    @PostMapping("/spread/list")
    public Response spreadGoodsList(GoodsDTO dto) {
        return goodsService.spreadGoodsList(dto);
    }

    @PostMapping("/spread/detail/{id}")
    public Response getSpreadGoods(@PathVariable long id) {
        return goodsService.getSpreadGoods(id);
    }

    @PostMapping("/spread/create")
    public Response createSpreadGoods(GoodsDTO dto) {
        return goodsService.createSpreadGoods(dto);
    }

    @PutMapping("/spread/update")
    public Response updateSpreadGoods(GoodsDTO dto) {
        return goodsService.updateSpreadGoods(dto);
    }
}
