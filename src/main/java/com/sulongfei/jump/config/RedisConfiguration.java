package com.sulongfei.jump.config;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Constant;
import com.sulongfei.jump.constants.Constants;
import com.sulongfei.jump.service.impl.RedisService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.DefaultRedisCachePrefix;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCachePrefix;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
    @Bean
    public KeyGenerator cacheKeyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName() + ":");
            sb.append(method.getName() + ":");
            for (Object obj : params) {
                // 由于参数可能不同, hashCode肯定不一样, 缓存的key也需要不一样
                sb.append(JSON.toJSONString(obj).hashCode());
            }
            return sb.toString();
        };
    }

    @Bean
    public CacheManager cacheManager(MyRedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(60);
        cacheManager.setUsePrefix(true);
        cacheManager.setCachePrefix(new DefaultRedisCachePrefix(":"));
        return cacheManager;
    }


    @Bean
    public MyRedisTemplate myRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        MyRedisTemplate template = new MyRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public RedisService redisService(MyRedisTemplate redisTemplate) {
        return new RedisService(redisTemplate);
    }
}
