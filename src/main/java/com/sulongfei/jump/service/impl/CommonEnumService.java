package com.sulongfei.jump.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sulongfei.jump.constants.Constants;
import com.sulongfei.jump.response.EnumRes;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.utils.SystemConfig;
import com.sulongfei.jump.utils.SystemConfigMap;
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
        result.putIfAbsent(Constants.Type.GOODS_TYPE, getGoodsType());

        return new Response<>(result);
    }

    private List<EnumRes> getGoodsType() {
        List<SystemConfig> goodsType = SystemConfigMap.get("goods_type");
        return getCommonInteger(goodsType);
    }

    /**
     * SystemConfig configKey 配置使用int型
     */
    private List<EnumRes> getCommonInteger(List<SystemConfig> systemConfigs) {
        List<EnumRes> configs = Lists.newArrayList();
        for (SystemConfig config : systemConfigs) {
            EnumRes res = new EnumRes(config.getConfigKey(), Integer.parseInt(config.getConfigType()), config.getConfigValue());
            configs.add(res);
        }
        return configs;
    }
}
