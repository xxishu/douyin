package com.sss.douyin.config;

import com.sss.douyin.service.UserService;
import com.sss.douyin.service.VideoService;
import com.sss.douyin.service.impl.UserServiceImpl;
import com.sss.douyin.service.impl.VideoServiceImpl;
import org.apache.ibatis.annotations.Property;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class SpringConfig {
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
    @Bean
    public VideoService videoService(){
        return new VideoServiceImpl();
    }
}
