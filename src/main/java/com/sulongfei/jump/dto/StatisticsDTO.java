package com.sulongfei.jump.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/16 14:27
 * @Version 1.0
 */
@Data
public class StatisticsDTO {
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date startTime;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date endTime;
    private List<Long> remoteClubIds;
}
