package com.sss.douyin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/douyin")
public class VideoController {
    /**
     * 视频流接口
     * @return
     */
    @RequestMapping("/feed")
    public String feed(){
        return null;
    }
    /**
     * 视频投稿
     * @return
     */
    @RequestMapping("/publish/action")
    public String publishAction(){
        return null;
    }
    /**
     * 视频发布列表
     * @return
     */
    @RequestMapping("/publish/list")
    public String publishList(){
        return null;
    }

    /**
     * 视频赞操作
     * @return
     */
    @RequestMapping("/favorite/action")
    public String favoriteAction(){
        return null;
    }
    /**
     * 视频点赞列表
     * @return
     */
    @RequestMapping("/favorite/list")
    public String favoriteList(){
        return null;
    }
    /**
     * 视频评论操作
     * @return
     */
    @RequestMapping("/comment/action")
    public String commentAction(){
        return null;
    }
    /**
     * 视频评论列表
     * @return
     */
    @RequestMapping("/comment/list")
    public String commentList(){
        return null;
    }

}
