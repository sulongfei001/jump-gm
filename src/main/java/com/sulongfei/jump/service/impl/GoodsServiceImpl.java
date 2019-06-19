package com.sulongfei.jump.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sulongfei.jump.constants.Constants;
import com.sulongfei.jump.constants.ResponseStatus;
import com.sulongfei.jump.dto.GoodsDTO;
import com.sulongfei.jump.mapper.GoodsMapper;
import com.sulongfei.jump.mapper.SpreadGoodsMapper;
import com.sulongfei.jump.model.Goods;
import com.sulongfei.jump.model.SpreadGoods;
import com.sulongfei.jump.response.GoodsRes;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.SpreadGoodsRes;
import com.sulongfei.jump.rest.response.GoodsResponse;
import com.sulongfei.jump.rest.response.RestResponse;
import com.sulongfei.jump.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

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
@CacheConfig(cacheNames = {Constants.CacheName.SERVICE_CACHE + Constants.CacheName.GOODS_CACHE})
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private RestService restService;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private SpreadGoodsMapper spreadGoodsMapper;

    @Override
    @Transactional(readOnly = false)
    @CacheEvict(allEntries = true)
    public Response createSpreadGoods(GoodsDTO goodsDTO) {
        SpreadGoods spreadGoods = new SpreadGoods();
        BeanUtils.copyProperties(goodsDTO, spreadGoods);
        spreadGoodsMapper.insertSelective(spreadGoods);
        return new Response();
    }

    @Override
    @Cacheable(key = "#root.caches[0].name+'goods.spread.list_'+#goodsDTO")
    public Response spreadGoodsList(GoodsDTO goodsDTO) {
        PageHelper.startPage(goodsDTO.getPage(), goodsDTO.getPageSize());
        List<SpreadGoods> list = spreadGoodsMapper.queryList(goodsDTO.getRemoteClubId(), goodsDTO.getGoodsName());
        List<SpreadGoodsRes> data = Lists.newArrayList();
        list.forEach(spreadGoods -> {
            SpreadGoodsRes spreadGoodsRes = new SpreadGoodsRes();
            BeanUtils.copyProperties(spreadGoods, spreadGoodsRes);
            data.add(spreadGoodsRes);
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }

    @Override
    @Cacheable(key = "#root.caches[0].name+'goods.local.list_'+#goodsDTO")
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
    @Cacheable(key = "#root.caches[0].name+'goods.local.all_'+#goodsDTO.remoteClubId")
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
    @Cacheable(key = "#root.caches[0].name+'goods.spread.'+#id")
    public Response getSpreadGoods(long id) {
        SpreadGoods spreadGoods = spreadGoodsMapper.selectByPrimaryKey(id);
        SpreadGoodsRes data = new SpreadGoodsRes();
        BeanUtils.copyProperties(spreadGoods, data);
        return new Response(data);
    }

    @Override
    @Transactional(readOnly = false)
    @CacheEvict(allEntries = true)
    public Response updateSpreadGoods(GoodsDTO dto) {
        SpreadGoods spreadGoods = new SpreadGoods();
        BeanUtils.copyProperties(dto, spreadGoods);
        spreadGoodsMapper.updateByPrimaryKeySelective(spreadGoods);
        return new Response();
    }

    @Override
    @Transactional(readOnly = false)
    @CacheEvict(allEntries = true)
    public Response synchronizeGoodsList() {
        ResponseEntity<RestResponse<List<GoodsResponse>>> res = restService.getGoodsList(null);
        if (!HttpStatus.OK.equals(res.getStatusCode()) || !"200".equals(res.getBody().getErrorCode())) {
            return new Response(ResponseStatus.SYNCHR_FAILURE);
        }
        for (GoodsResponse response : res.getBody().getResult()) {
            Goods goods = goodsMapper.selectByRemoteGoodsId(response.getGoodsId());
            if (goods != null) {
                // 更新
                if (compare(response, goods)) {
                    continue;
                }
                toGoods(response, goods);
                goodsMapper.updateByPrimaryKey(goods);
            } else {
                goods = new Goods();
                toGoods(response, goods);
                goods.setRemainNum(response.getStockNum());
                goodsMapper.insertSelective(goods);
            }
        }
        return new Response();
    }

    private Goods toGoods(GoodsResponse res, Goods goods) {
        goods.setRemoteGoodsId(res.getGoodsId());
        goods.setRemoteClubId(res.getOrgId());
        goods.setGoodsName(res.getName());
        goods.setGoodsNum(res.getStockNum());
        goods.setGoodsPrice(res.getPrice());
        goods.setGoodsPicture(res.getLogo());
        goods.setDetailPicture(res.getDetailLogo());
        return goods;
    }

    private Boolean compare(GoodsResponse res, Goods goods) {
        if (!ObjectUtils.isEmpty(res.getGoodsId()) && res.getGoodsId().equals(goods.getRemoteGoodsId()) &&
                !ObjectUtils.isEmpty(res.getOrgId()) && res.getOrgId().equals(goods.getRemoteClubId()) &&
                !ObjectUtils.isEmpty(res.getName()) && res.getName().equals(goods.getGoodsName()) &&
                !ObjectUtils.isEmpty(res.getLogo()) && res.getLogo().equals(goods.getGoodsPicture()) &&
                !ObjectUtils.isEmpty(res.getDetailLogo()) && res.getDetailLogo().equals(goods.getDetailPicture()) &&
                !ObjectUtils.isEmpty(res.getStockNum()) && res.getStockNum().equals(goods.getGoodsNum()) &&
                !ObjectUtils.isEmpty(res.getPrice()) && res.getPrice().compareTo(goods.getGoodsPrice()) == 0
        ) {
            return true;
        } else {
            return false;
        }
    }
}
