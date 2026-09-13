package com.bit.blog.service;

import com.bit.blog.pojo.request.UserLoginRequest;
import com.bit.blog.pojo.response.UserInfoResponse;
import com.bit.blog.pojo.response.UserloginResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoService {
    UserloginResponse checkPassword(UserLoginRequest userLoginRequest);

    UserInfoResponse getUserInfo(Integer userId);

    UserInfoResponse getAuthorInfo(Integer blogId);
}
