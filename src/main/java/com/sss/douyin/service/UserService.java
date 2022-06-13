package com.sss.douyin.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Integer addUser(String username, String password);

    Integer findUser(String username, String password);

    Integer login(String username, String password);
}
