package com.sss.douyin.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Video {
    Integer id;
    Integer authorid;
    String title;
    String play_url;
    String cover_url;
    Long updatetime;
    List<User> favorite;
    List<String> comment;

}
