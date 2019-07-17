package com.sulongfei.jump.mapper;

import com.sulongfei.jump.dto.StatisticsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Mapper
public interface StatisticsMapper {
    List<Integer> registerStatistics(StatisticsDTO dto);

    List<Integer> chargeStatistics(StatisticsDTO dto);

    Integer registerCount(StatisticsDTO dto);

    BigDecimal chargeCount(StatisticsDTO dto);

    Integer chargePeople(StatisticsDTO dto);
}
