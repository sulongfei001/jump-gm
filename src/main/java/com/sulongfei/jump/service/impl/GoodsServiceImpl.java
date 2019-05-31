package com.sulongfei.jump.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sulongfei.jump.dto.GoodsDTO;
import com.sulongfei.jump.mapper.GoodsMapper;
import com.sulongfei.jump.mapper.SpreadGoodsMapper;
import com.sulongfei.jump.model.Goods;
import com.sulongfei.jump.model.SpreadGoods;
import com.sulongfei.jump.response.GoodsRes;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.SpreadGoodsRes;
import com.sulongfei.jump.service.GoodsService;
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
 * @Date 2019/5/23 19:15
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private SpreadGoodsMapper spreadGoodsMapper;

    @Override
    public Response synchronizeGoodsList() {
        return new Response();
    }

    @Override
    @Transactional(readOnly = false)
    public Response createSpreadGoods(GoodsDTO goodsDTO) {
        SpreadGoods spreadGoods = new SpreadGoods();
        BeanUtils.copyProperties(goodsDTO,spreadGoods);
        spreadGoodsMapper.insertSelective(spreadGoods);
        return new Response();
    }

    @Override
    public Response spreadGoodsList(GoodsDTO goodsDTO) {
        PageHelper.startPage(goodsDTO.getPage(), goodsDTO.getPageSize());
        List<SpreadGoods> list = spreadGoodsMapper.queryList(goodsDTO.getRemoteClubId(),goodsDTO.getGoodsName());
        List<SpreadGoodsRes> data = Lists.newArrayList();
        list.forEach(spreadGoods -> {
            SpreadGoodsRes spreadGoodsRes = new SpreadGoodsRes();
            BeanUtils.copyProperties(spreadGoods, spreadGoodsRes);
            data.add(spreadGoodsRes);
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }

    @Override
    public Response localGoodsList(GoodsDTO goodsDTO) {
        PageHelper.startPage(goodsDTO.getPage(), goodsDTO.getPageSize());
        List<Goods> list = goodsMapper.queryList(goodsDTO.getRemoteClubId());
        List<GoodsRes> data = Lists.newArrayList();
        list.forEach(goods -> {
            GoodsRes goodsRes = new GoodsRes();
            BeanUtils.copyProperties(goods, goodsRes);
            data.add(goodsRes);
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }

    @Override
    public Response localGoodsAll(GoodsDTO goodsDTO) {
        List<Goods> list = goodsMapper.selectByClubId(goodsDTO.getRemoteClubId());
        List<GoodsRes> data = Lists.newArrayList();
        list.forEach(goods -> {
            GoodsRes goodsRes = new GoodsRes();
            BeanUtils.copyProperties(goods, goodsRes);
            data.add(goodsRes);
        });
        return new Response(data);
    }

    @Override
    public Response getSpreadGoods(long id) {
        SpreadGoods spreadGoods = spreadGoodsMapper.selectByPrimaryKey(id);
        SpreadGoodsRes data = new SpreadGoodsRes();
        BeanUtils.copyProperties(spreadGoods, data);
        return new Response(data);
    }

    @Override
    @Transactional(readOnly = false)
    public Response updateSpreadGoods(GoodsDTO dto) {
        SpreadGoods spreadGoods = new SpreadGoods();
        BeanUtils.copyProperties(dto, spreadGoods);
        spreadGoodsMapper.updateByPrimaryKeySelective(spreadGoods);
        return new Response();
    }
}
