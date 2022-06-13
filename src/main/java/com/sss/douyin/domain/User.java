package com.sss.douyin.domain;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Data
public class User {
    public Integer id;
    public String username;
    public String password;

    public List<User> follow;
    public List<User> follower;


}
