package com.sulongfei.jump.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sulongfei.jump.dto.ClubDTO;
import com.sulongfei.jump.mapper.ClubMapper;
import com.sulongfei.jump.model.Club;
import com.sulongfei.jump.response.ClubRes;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/24 16:18
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubMapper clubMapper;

    @Override
    public Response localClubList(ClubDTO clubDTO) {
        PageHelper.startPage(clubDTO.getPage(), clubDTO.getPageSize());
        List<Club> list = clubMapper.queryList();
        List<ClubRes> data = Lists.newArrayList();
        list.forEach(club -> {
            data.add(new ClubRes(club.getId(), club.getRemoteClubId(), club.getClubName()));
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }

    @Override
    public Response localClubAll() {
        List<Club> list = clubMapper.selectAll();
        List<ClubRes> data = Lists.newArrayList();
        list.forEach(club -> {
            data.add(new ClubRes(club.getId(), club.getRemoteClubId(), club.getClubName()));
        });
        return Response.toResponse(data, data.size());
    }

    @Override
    public Response synchronizeClubList() {
        return new Response();
    }
}
