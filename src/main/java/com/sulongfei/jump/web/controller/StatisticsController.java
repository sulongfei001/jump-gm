package com.sulongfei.jump.web.controller;

import com.sulongfei.jump.dto.StatisticsDTO;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/16 14:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/dashboard")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @PostMapping("/statistics")
    public Response lineChart(@RequestBody StatisticsDTO dto){
        return statisticsService.lineChart(dto);
    }
}
