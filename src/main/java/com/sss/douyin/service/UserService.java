package com.sss.douyin.service;

import com.sss.douyin.domain.User;
import com.sss.douyin.domain.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Integer addUser(String username, String password);

    Integer findUser(String username, String password);

    User getUser(Integer userId);

    UserDTO login(String username, String password);
}
