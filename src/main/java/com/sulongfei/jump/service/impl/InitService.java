package com.sulongfei.jump.service.impl;

import com.sulongfei.jump.utils.SystemConfig;
import com.sulongfei.jump.utils.SystemConfigMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InitService {

    @PostConstruct
    public void init() {

        log.info("开始加载JVM缓存。。。");
        initConfig();
        log.info("加载JVM缓存结束。。。");
    }

    private void initConfig() {
        log.info("初始化系统配置");
        List<SystemConfig> systemConfigs = new ArrayList<SystemConfig>() {
            {
                add(new SystemConfig("goods_type", "1", "周卡"));
                add(new SystemConfig("goods_type", "2", "寄送"));
                add(new SystemConfig("goods_type", "3", "门店兑换"));
            }
        };

        Map<String, List<SystemConfig>> map = systemConfigs.stream().collect(Collectors.groupingBy(SystemConfig::getConfigKey));
        SystemConfigMap.putAllSystemConfig(map);
    }
}
