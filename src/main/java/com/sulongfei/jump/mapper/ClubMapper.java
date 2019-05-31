package com.sulongfei.jump.mapper;

import com.sulongfei.jump.model.Club;

import java.util.List;

public interface ClubMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Club record);

    int insertSelective(Club record);

    Club selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Club record);

    int updateByPrimaryKey(Club record);

    List<Club> selectAll();

    List<Club> queryList();
}