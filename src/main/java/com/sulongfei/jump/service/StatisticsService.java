package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.StatisticsDTO;
import com.sulongfei.jump.response.Response;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/16 14:25
 * @Version 1.0
 */
public interface StatisticsService {
    Response lineChart(StatisticsDTO dto);
}
