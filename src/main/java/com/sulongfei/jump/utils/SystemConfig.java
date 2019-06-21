package com.sulongfei.jump.utils;

import lombok.Data;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/19 15:04
 * @Version 1.0
 */
@Data
public class SystemConfig {
    private String configKey;
    private String configType;
    private String configValue;

    public SystemConfig(String configKey, String configType, String configValue) {
        this.configKey = configKey;
        this.configType = configType;
        this.configValue = configValue;
    }
}
