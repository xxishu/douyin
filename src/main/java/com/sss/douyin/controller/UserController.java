package com.sss.douyin.controller;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.sss.douyin.result.RegisterResult;
import com.sss.douyin.domain.UserDTO;
import com.sss.douyin.result.UserinfoResult;
import com.sss.douyin.service.UserService;
import com.sss.douyin.util.TokenHolder;
import com.sss.douyin.util.TokenUtil;
import com.sss.douyin.util.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/douyin")
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    public TokenHolder tokenHolder;

    /**
     * 用户信息
     * @return
     */
    @RequestMapping("/user")
    public String UserInfo(){
        UserDTO user = UserHolder.getUser();
        if(user == null) return null;

        UserinfoResult ret = UserinfoResult.success(user);
        return JSONUtil.toJsonStr(ret);
    }
    /**
     * 用户登录接口
     * @return
     */
    @RequestMapping("/user/login")
    public String userRegister(String username, String password){
        RegisterResult ret;
        UserDTO userDTO = userService.login(username, password);
        Integer id = userDTO.getId();
        if(id == null){
            ret = RegisterResult.error("登陆失败");
            return JSONUtil.toJsonStr(ret);
        }
        String token = TokenUtil.getToken(username, password);
        ret = RegisterResult.success(id, token);

        //存token
        tokenHolder.setUser(JSONUtil.toJsonStr(userDTO), token);

        return JSONUtil.toJsonStr(ret);
    }

//    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("username", "123456");
//        map.put("password", "123456");
//        String s = JSONUtil.toJsonStr(map);
//        System.out.println("s = " + s);
//    }
    /**
     * 用户注册接口
     * @return
     */
    @PostMapping("/user/register")
    public String userLogin(String username, String password){
        RegisterResult ret;
        Integer id = userService.findUser(username, password);
        if(id != null){
            ret = RegisterResult.error("注册失败");
            return JSONUtil.toJsonStr(ret);
        }
        id = userService.addUser(username, password);
        String token = TokenUtil.getToken(username, password);
        ret = RegisterResult.success(id, token);

        //存token
        UserDTO userDTO = userService.login(username, password);
        tokenHolder.setUser(JSONUtil.toJsonStr(userDTO), token);

        return JSONUtil.toJsonStr(ret);
    }

    /**
     * 关系操作
     * @return
     */
    @RequestMapping("/relation/action")
    public String relationAction(){
        return null;
    }

    /**
     * 用户关注列表
     * @return
     */
    @RequestMapping("/relation/follow/list")
    public String relationFollowList(){
        return null;
    }
    /**
     * 用户粉丝列表
     * @return
     */
    @RequestMapping("/relation/follower/list")
    public String relationFollowerList(){
        return null;
    }

}
