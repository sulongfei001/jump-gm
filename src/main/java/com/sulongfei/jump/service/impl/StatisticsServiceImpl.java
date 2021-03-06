package com.sulongfei.jump.service.impl;

import com.google.common.collect.Lists;
import com.sulongfei.jump.dto.StatisticsDTO;
import com.sulongfei.jump.mapper.StatisticsMapper;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.StatisticsRes;
import com.sulongfei.jump.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/16 14:25
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;

    @Override
    public Response lineChart(StatisticsDTO dto) {
        StatisticsRes data = new StatisticsRes();
        List<Integer> registerData = statisticsMapper.registerStatistics(dto);
        List<Integer> chargeData = statisticsMapper.chargeStatistics(dto);
        Integer registerCount = statisticsMapper.registerCount(dto);
        BigDecimal chargeCount = statisticsMapper.chargeCount(dto);
        Integer chargePeople = statisticsMapper.chargePeople(dto);
        List<Date> xAxisData = getBetweenDates(dto.getStartTime(), dto.getEndTime());
        data.setRegisterData(registerData);
        data.setChargeData(chargeData);
        data.setXaxisData(xAxisData);
        data.setRegisterCount(registerCount);
        data.setChargeCount(chargeCount);
        data.setChargePeople(chargePeople);
        return new Response(data);
    }

    private List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = Lists.newArrayList();
        if (ObjectUtils.isEmpty(start) || ObjectUtils.isEmpty(end)) return result;
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        result.add(start);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        result.add(end);
        return result;
    }
}
