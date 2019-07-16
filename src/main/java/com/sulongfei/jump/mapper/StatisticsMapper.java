package com.sulongfei.jump.mapper;

import com.sulongfei.jump.dto.StatisticsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StatisticsMapper {
    List<Integer> registerStatistics(StatisticsDTO dto);
}
