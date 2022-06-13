package com.sss.douyin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import com.sss.douyin.domain.User;
import com.sss.douyin.domain.UserDTO;
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
    public User getUser(Integer userId) {
        User user = userMapper.findUserById(userId);
        if(user == null) return null;
        //TODO 找到粉丝和关注的人的列表
        return user;
    }


    @Override
    public UserDTO login(String username, String password) {
        Integer userId = this.findUser(username, password);
        if(userId == null) return null;
        User user = this.getUser(userId);
        UserDTO userDTO = this.user2UserDTO(user);
        return userDTO;
    }

    public UserDTO user2UserDTO(User user){
        if(user == null) return null;
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getUsername());
        if(user.getFollow() == null) {
            userDTO.setFollowCount(0);
        } else {
            userDTO.setFollowCount(user.getFollow().size());
        }
        if(user.getFollower() == null) {
            userDTO.setFollowerCount(0);
        } else {
            userDTO.setFollowerCount(user.getFollower().size());
        }
        return userDTO;
    }

}
