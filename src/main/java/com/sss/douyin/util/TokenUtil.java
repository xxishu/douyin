package com.sss.douyin.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {
    private static final String TOKEN_SECRET = "douyin";

    public static String getToken(String username, String password) {
        String token = "";
        try {
            //过期时间
            Calendar insCalendar = Calendar.getInstance();
            insCalendar.add(Calendar.SECOND, 800);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("password", password)
                    .withExpiresAt(insCalendar.getTime())
                    .sign(algorithm);
        } catch (Exception e) {
            System.out.println("*****");
            e.printStackTrace();
            return null;
        }
        return token;
    }


}