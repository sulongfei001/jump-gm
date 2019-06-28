package com.sulongfei.jump.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sulongfei.jump.constants.Constants;
import com.sulongfei.jump.dto.RoomSimpleDTO;
import com.sulongfei.jump.mapper.RecordSimpleMapper;
import com.sulongfei.jump.mapper.RoomSimpleMapper;
import com.sulongfei.jump.model.RecordSimple;
import com.sulongfei.jump.model.RoomSimple;
import com.sulongfei.jump.response.RecordSimpleRes;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.RoomSimpleRes;
import com.sulongfei.jump.service.RoomSimpleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/24 13:59
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
@CacheConfig(cacheNames = {Constants.CacheName.SERVICE_CACHE + Constants.CacheName.SIMPLE_ROOM_CACHE})
public class RoomSimpleServiceImpl implements RoomSimpleService {

    @Autowired
    private RoomSimpleMapper roomSimpleMapper;
    @Autowired
    private RecordSimpleMapper recordSimpleMapper;

    @Override
    @Transactional(readOnly = false)
    @CacheEvict(allEntries = true)
    public Response createSimpleRoom(RoomSimpleDTO dto) {
        RoomSimple roomSimple = new RoomSimple();
        BeanUtils.copyProperties(dto, roomSimple);
        roomSimple.setConsumeNum(0);
        roomSimple.setCreateTime(new Timestamp(System.currentTimeMillis()));
        roomSimpleMapper.insertSelective(roomSimple);
        return new Response();
    }

    @Override
    @Cacheable(keyGenerator = "cacheKeyGenerator")
    public Response simpleList(RoomSimpleDTO roomDTO) {
        PageHelper.startPage(roomDTO.getPage(), roomDTO.getPageSize());
        List<RoomSimple> list = roomSimpleMapper.selectRoomSimple(roomDTO.getRemoteClubId());
        List<RoomSimpleRes> data = Lists.newArrayList();
        list.forEach(roomSimple -> {
            RoomSimpleRes roomSimpleRes = new RoomSimpleRes();
            BeanUtils.copyProperties(roomSimple, roomSimpleRes);
            Integer prizeCount = recordSimpleMapper.countPrize(roomSimple.getId());
            roomSimpleRes.setPrizeCount(prizeCount);
            data.add(roomSimpleRes);
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }

    @Override
    @Transactional(readOnly = false)
    @CacheEvict(allEntries = true)
    public Response deleteSimpleRoom(long id) {
        roomSimpleMapper.deleteByPrimaryKey(id);
        return new Response();
    }

    @Override
    @Cacheable(keyGenerator = "cacheKeyGenerator")
    public Response getSimpleRoom(long id) {
        RoomSimple roomSimple = roomSimpleMapper.selectByPrimaryKey(id);
        RoomSimpleRes data = new RoomSimpleRes();
        if (roomSimple != null) BeanUtils.copyProperties(roomSimple, data);
        return new Response(data);
    }

    @Override
    @Transactional(readOnly = false)
    @CacheEvict(allEntries = true)
    public Response updateSimpleRoom(RoomSimpleDTO dto) {
        RoomSimple roomSimple = new RoomSimple();
        BeanUtils.copyProperties(dto, roomSimple);
        roomSimpleMapper.updateByPrimaryKeySelective(roomSimple);
        return new Response();
    }

    @Override
    @Cacheable(keyGenerator = "cacheKeyGenerator")
    public Response prizeList(RoomSimpleDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        List<RecordSimple> list = recordSimpleMapper.selectByRoomId(dto.getId());
        List<RecordSimpleRes> data = Lists.newArrayList();
        list.forEach(recordSimple -> {
            RecordSimpleRes res = new RecordSimpleRes();
            BeanUtils.copyProperties(recordSimple, res);
            data.add(res);
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }

    @Override
    @Transactional(readOnly = false)
    @CacheEvict(allEntries = true)
    public Response sortSimpleRoom(List<RoomSimpleDTO> list) {
        int num = roomSimpleMapper.batchSort(list);
        return new Response();
    }
}
