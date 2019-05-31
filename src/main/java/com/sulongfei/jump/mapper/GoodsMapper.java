package com.sulongfei.jump.mapper;

import com.sulongfei.jump.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> queryList(@Param("remoteClubId") Long remoteClubId);

    List<Goods> selectByClubId(@Param("remoteClubId") Long remoteClubId);
}