package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.SysConfigDTO;
import com.sulongfei.jump.response.Response;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/19 10:31
 * @Version 1.0
 */
public interface SysConfigService {
    Response sysConfig();

    Response updateSysConfig(SysConfigDTO dto);
}
