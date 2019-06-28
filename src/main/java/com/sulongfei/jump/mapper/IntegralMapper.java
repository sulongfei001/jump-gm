package com.sulongfei.jump.mapper;

import com.sulongfei.jump.model.Integral;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IntegralMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Integral record);

    int insertSelective(Integral record);

    Integral selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Integral record);

    int updateByPrimaryKey(Integral record);

}