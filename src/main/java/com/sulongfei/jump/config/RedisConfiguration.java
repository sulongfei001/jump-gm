package com.sulongfei.jump.config;

import com.sulongfei.jump.service.impl.RedisService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager(MyRedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(60);
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
