package com.sss.douyin.util;

import com.sss.douyin.domain.UserDTO;
import com.sss.douyin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class UserHolder {

    private static ThreadLocal<UserDTO> users = new ThreadLocal<>();
    public static UserDTO getUser(){
        return users.get();
    }
    public static void setUser(UserDTO userDTO){
        users.set(userDTO);
    }
}
