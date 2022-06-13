package com.sss.douyin.result;

import com.sss.douyin.constant.ResponseStatusConstant;
import lombok.Data;

@Data
public class RegisterResult extends CommonResult{
    private Integer user_id;
    private String token;

    public static RegisterResult error(String message) {
        RegisterResult result = new RegisterResult();
        result.setStatus_code(ResponseStatusConstant.ERROR);
        result.setStatus_msg(message);
        return result;
    }

    public static RegisterResult success(Integer id, String token) {
        RegisterResult result = new RegisterResult();
        result.setStatus_code(ResponseStatusConstant.SUCCESS);
        result.setStatus_msg("ok");
        result.setUser_id(id);
        result.setToken(token);
        return result;
    }

}
