package com.sulongfei.jump.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sulongfei.jump.dto.RoomDTO;
import com.sulongfei.jump.mapper.RoomSimpleMapper;
import com.sulongfei.jump.model.RoomSimple;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.RoomSimpleRes;
import com.sulongfei.jump.service.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomSimpleMapper roomSimpleMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public Response createSimpleRoom(RoomDTO dto) {
        RoomSimple roomSimple = new RoomSimple();
        BeanUtils.copyProperties(dto, roomSimple);
        roomSimple.setCreateTime(new Timestamp(System.currentTimeMillis()));
        roomSimpleMapper.insertSelective(roomSimple);
        return new Response();
    }

    @Override
    public Response simpleList(RoomDTO roomDTO) {
        PageHelper.startPage(roomDTO.getPage(), roomDTO.getPageSize());
        List<RoomSimple> list = roomSimpleMapper.selectRoomSimple(roomDTO.getRemoteClubId());
        List<RoomSimpleRes> data = Lists.newArrayList();
        list.forEach(roomSimple -> {
            RoomSimpleRes roomSimpleRes = new RoomSimpleRes();
            BeanUtils.copyProperties(roomSimple, roomSimpleRes);
            data.add(roomSimpleRes);
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }

    @Override
    @Transactional(readOnly = false)
    public Response deleteSimpleRoom(long id) {
        roomSimpleMapper.deleteByPrimaryKey(id);
        return new Response();
    }

    @Override
    public Response getSimpleRoom(long id) {
        RoomSimple roomSimple = roomSimpleMapper.selectByPrimaryKey(id);
        RoomSimpleRes data = new RoomSimpleRes();
        if (roomSimple != null) BeanUtils.copyProperties(roomSimple, data);
        return new Response(data);
    }

    @Override
    @Transactional(readOnly = false)
    public Response updateSimpleRoom(RoomDTO dto) {
        RoomSimple roomSimple = new RoomSimple();
        BeanUtils.copyProperties(dto, roomSimple);
        roomSimpleMapper.updateByPrimaryKeySelective(roomSimple);
        return new Response();
    }
}
