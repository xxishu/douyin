package com.sss.douyin.domain;

import lombok.Data;

@Data
public class UserDTO {
    public Integer id;
    public String name;
    public Integer followCount;
    public Integer followerCount;
}
