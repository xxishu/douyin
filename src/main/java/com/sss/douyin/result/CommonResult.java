package com.sss.douyin.result;

import com.sss.douyin.constant.ResponseStatusConstant;
import lombok.Data;

/**
 * @author sunxw
 * @description 公共返回类
 * @since 1.0-Snapshoot
 */
@Data
public class CommonResult {
    /**
     * 状态码，0-成功，其他值-失败
     */
    private String status_code;

    /**
     * 返回状态描述
     */
    private String status_msg;


    public static CommonResult error(String message) {
        CommonResult result = new CommonResult();
        result.setStatus_code(ResponseStatusConstant.ERROR);
        result.setStatus_msg(message);
        return result;
    }

    public static CommonResult success() {
        CommonResult result = new CommonResult();
        result.setStatus_code(ResponseStatusConstant.SUCCESS);
        result.setStatus_msg("ok");
        return result;
    }

}
