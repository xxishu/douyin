package com.sss.douyin.result;

import com.sss.douyin.constant.ResponseStatusConstant;
import com.sss.douyin.domain.VideoDTO;
import lombok.Data;

import java.util.List;

@Data
public class VideosResult extends CommonResult{
    /**
     * 返回视频列表
     */
    private List<VideoDTO> video_list;
    /**
     * 返回这批视频最早发布时间
     */
    private long next_time;


    public static VideosResult error(String message) {
        VideosResult result = new VideosResult();
        result.setStatus_code(ResponseStatusConstant.ERROR);
        result.setStatus_msg(message);
        return result;
    }

    public static VideosResult success(List<VideoDTO> videos, long nextTime) {
        VideosResult result = new VideosResult();
        result.setStatus_code(ResponseStatusConstant.SUCCESS);
        result.setStatus_msg("ok");
        result.setNext_time(nextTime);
        result.setVideo_list(videos);
        return result;
    }
}
