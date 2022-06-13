package com.sss.douyin.result;

import com.sss.douyin.constant.ResponseStatusConstant;
import com.sss.douyin.domain.UserDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserinfoResult extends CommonResult{
    private List<UserDTO> users;
    public static UserinfoResult error(String message) {
        UserinfoResult result = new UserinfoResult();
        result.setStatus_code(ResponseStatusConstant.ERROR);
        result.setStatus_msg(message);
        return result;
    }

    public static UserinfoResult success(UserDTO userDTO) {
        UserinfoResult result = new UserinfoResult();
        result.setStatus_code(ResponseStatusConstant.SUCCESS);
        result.setStatus_msg("ok");
        result.users = new ArrayList<>();
        result.users.add(userDTO);
        return result;
    }
}
