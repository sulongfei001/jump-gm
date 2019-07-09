package com.sulongfei.jump.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sulongfei.jump.dto.TicketDTO;
import com.sulongfei.jump.dto.UserDTO;
import com.sulongfei.jump.mapper.ClubMapper;
import com.sulongfei.jump.mapper.SecurityUserMapper;
import com.sulongfei.jump.mapper.TicketMapper;
import com.sulongfei.jump.model.Club;
import com.sulongfei.jump.model.Record;
import com.sulongfei.jump.model.SecurityUser;
import com.sulongfei.jump.model.Ticket;
import com.sulongfei.jump.response.RecordRes;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.TicketRes;
import com.sulongfei.jump.response.UserRes;
import com.sulongfei.jump.service.UserService;
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
 * @Date 2019/7/1 10:26
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private SecurityUserMapper userMapper;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private ClubMapper clubMapper;

    @Override
    public Response userList(UserDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        List<SecurityUser> list = userMapper.selectByPage(dto.getId(), dto.getPhoneNumber());
        List<UserRes> data = Lists.newArrayList();
        list.forEach(user -> {
            UserRes res = new UserRes();
            BeanUtils.copyProperties(user, res);
            data.add(res);
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }

    @Override
    @Transactional(readOnly = false)
    public Response update(UserDTO dto) {
        SecurityUser user = userMapper.selectByPrimaryKey(dto.getId());
        user.setNickname(dto.getNickname());
        userMapper.updateByPrimaryKey(user);
        return null;
    }

    @Override
    public Response ticketLog(UserDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        List<Record> list = userMapper.selectRecord(dto.getId());
        List<RecordRes> data = Lists.newArrayList();
        list.forEach(record -> {
            RecordRes res = new RecordRes();
            BeanUtils.copyProperties(record, res);
            data.add(res);
        });
        Long num = new PageInfo<>(list).getTotal();
        return Response.toResponse(data, num);
    }

    @Override
    public Response ticketList(TicketDTO dto) {
        List<Ticket> list = ticketMapper.selectByUserId(dto.getUserId());
        List<TicketRes> data = Lists.newArrayList();
        list.forEach(ticket -> {
            Club club = clubMapper.selectByOrgId(ticket.getRemoteClubId());
            TicketRes res = new TicketRes();
            BeanUtils.copyProperties(ticket, res);
            res.setSupplierName(club.getSupplierName());
            data.add(res);
        });
        return Response.toResponse(data, data.size());
    }

    @Override
    public Response oneTicket(TicketDTO dto) {
        Ticket ticket = ticketMapper.selectByClubId(dto.getUserId(), dto.getRemoteClubId());
        TicketRes ticketRes = new TicketRes();
        BeanUtils.copyProperties(ticket, ticketRes);
        return new Response(ticketRes);
    }

    @Override
    @Transactional(readOnly = false)
    public Response modifyTicket(TicketDTO dto) {
        Ticket ticket = ticketMapper.selectByClubId(dto.getUserId(),dto.getRemoteClubId());
        ticket.setNum(dto.getNum());
        ticketMapper.updateByPrimaryKey(ticket);
        return new Response();
    }
}
