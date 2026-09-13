package com.bit.blog.controller;

import com.bit.blog.pojo.dataobject.UserInfo;
import com.bit.blog.pojo.request.UserLoginRequest;
import com.bit.blog.pojo.response.UserInfoResponse;
import com.bit.blog.pojo.response.UserloginResponse;
import com.bit.blog.service.UserInfoService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RequestMapping("/user")
@RestController
@Validated
public class UserInfoController {
    @Resource
    private UserInfoService userService;
    @RequestMapping("/login")
    public UserloginResponse login(@RequestBody @Valid UserLoginRequest userLoginRequest){
        log.info("用户登录，用户名："+userLoginRequest.getUserName());
        return userService.checkPassword(userLoginRequest);
    }
    @RequestMapping("/getUserInfo")
    public UserInfoResponse getUserInfo(@NotNull(message = "userId不能为空") Integer userId){
        log.info("获取用户信息，userId:"+userId);
        return userService.getUserInfo(userId);

    }
    @RequestMapping("/getAuthorInfo")
    public UserInfoResponse getAuthorInfo(@NotNull(message = "blogId不能为空") Integer blogId){
        log.info("获取作者信息，blogId:"+blogId);
        return userService.getAuthorInfo(blogId);
    }
}



































