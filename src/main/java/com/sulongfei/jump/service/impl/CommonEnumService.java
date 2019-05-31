package com.sulongfei.jump.service.impl;

import com.google.common.collect.Maps;
import com.sulongfei.jump.response.EnumRes;
import com.sulongfei.jump.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通用枚举服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class CommonEnumService {

    public Response<Map<String, List<EnumRes>>> getCommonEnumInfo() {

        Map<String, List<EnumRes>> result = Maps.newConcurrentMap();

        return new Response<>(result);
    }
}
