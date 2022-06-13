package com.sss.douyin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.sss.douyin.domain.User;
import com.sss.douyin.mapper.UserMapper;
import com.sss.douyin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer addUser(String username, String password) {
        if(StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) return null;
        User user = userMapper.findUserByUsername(username);
        if(user != null) {
            return -1;
        }
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Integer id = userMapper.addUser(user);
        return id;
    }

    @Override
    public Integer findUser(String username, String password) {
        if(username == null || password == null) return null;
        User user = userMapper.findUserByUsername(username);
        if(user == null || !password.equals(user.password)){
            return null;
        }
        return user.id;
    }

    @Override
    public Integer login(String username, String password) {
        return null;
    }


}
