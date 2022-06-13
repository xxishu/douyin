package com.sss.douyin.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class TokenHolder {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private static ConcurrentHashMap<String, String> tokenUserMap = new ConcurrentHashMap<>();
    public static String getUser(String token){
        if(token == null) return null;
        return tokenUserMap.get(token);

    }
    public static void setUser(String user, String token){
        tokenUserMap.put(token, user);
    }
}
