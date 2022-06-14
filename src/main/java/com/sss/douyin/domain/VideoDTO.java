package com.sss.douyin.domain;

import lombok.Data;

import java.util.List;

@Data
public class VideoDTO {
    Integer id;
    UserDTO author;
    String title;
    String play_url;
    String cover_url;
    Integer favorite_count;
    Integer comment_count;
    Boolean is_favorite;
}
