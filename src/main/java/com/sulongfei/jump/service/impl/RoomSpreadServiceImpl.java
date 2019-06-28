package com.sulongfei.jump.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sulongfei.jump.constants.Constants;
import com.sulongfei.jump.dto.RoomSpreadDTO;
import com.sulongfei.jump.mapper.RecordSpreadMapper;
import com.sulongfei.jump.mapper.RoomSpreadMapper;
import com.sulongfei.jump.mapper.SecurityUserMapper;
import com.sulongfei.jump.model.RecordSpread;
import com.sulongfei.jump.model.RoomSpread;
import com.sulongfei.jump.model.SecurityUser;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.RoomSpreadRes;
import com.sulongfei.jump.response.SpreadGoodsRes;
import com.sulongfei.jump.response.UserRes;
import com.sulongfei.jump.service.RoomSpreadService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/18 18:00
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
@CacheConfig(cacheNames = {Constants.CacheName.SERVICE_CACHE + Constants.CacheName.SPREAD_ROOM_CACHE})
public class RoomSpreadServiceImpl implements RoomSpreadService {
    @Autowired
    private RoomSpreadMapper roomSpreadMapper;
    @Autowired
    private RecordSpreadMapper recordSpreadMapper;
    @Autowired
    private SecurityUserMapper userMapper;

    @Override
    @Cacheable(keyGenerator = "cacheKeyGenerator")
    public Response spreadList(RoomSpreadDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        List<RoomSpread> list = roomSpreadMapper.selectByPage(dto.getRemoteClubId());
        List<RoomSpreadRes> data = Lists.newArrayList();
        list.forEach(roomSpread -> {
            RoomSpreadRes res = new RoomSpreadRes();
            BeanUtils.copyProperties(roomSpread, res);
            if (roomSpread.getSpreadGoods() != null) {
                SpreadGoodsRes goodsRes = new SpreadGoodsRes();
                BeanUtils.copyProperties(roomSpread.getSpreadGoods(), goodsRes);
                res.setSpreadGoods(goodsRes);
            }
            if (roomSpread.getWinRecordId() != null && roomSpread.getWinRecordId() != -1 && roomSpread.getStatus() == 1) {
                // 获胜记录
                RecordSpread recordSpread = recordSpreadMapper.selectByPrimaryKey(roomSpread.getWinRecordId());
                if (recordSpread != null) {
                    SecurityUser securityUser = userMapper.selectByPrimaryKey(recordSpread.getUserId());
                    if (securityUser != null) {
                        UserRes user = new UserRes();
                        BeanUtils.copyProperties(securityUser, user);
                        res.setUser(user);
                        res.setWinTime(recordSpread.getCreateTime());
                    }
                }
            }
            data.add(res);
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }
}
