package com.sss.douyin.config;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sss.douyin.domain.UserDTO;
import com.sss.douyin.util.TokenHolder;
import com.sss.douyin.util.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    TokenHolder tokenHolder;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置登录逻辑
        registry.addInterceptor(new HandlerInterceptor() {
                    @Override
                    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                        try {
                            String token = (String) request.getAttribute("token");
//                        String userJson = (String) redisTemplate.opsForValue().get("login:token:" + token);
                            String userJson = tokenHolder.getUser(token);
                            if(token != null && userJson != null){
                                UserDTO userDTO = JSONUtil.toBean(userJson, UserDTO.class);
                                UserHolder.setUser(userDTO);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            return true;
                        }
                    }
                }).addPathPatterns("/**");
    }

}
