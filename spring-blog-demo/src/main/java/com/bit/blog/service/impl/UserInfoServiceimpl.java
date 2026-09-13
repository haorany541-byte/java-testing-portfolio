package com.bit.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bit.blog.common.exception.BlogException;
import com.bit.blog.common.util.BeanTransUtils;
import com.bit.blog.common.util.JwtUtils;
import com.bit.blog.common.util.SecurityUtil;
import com.bit.blog.mapper.UserInfoMapper;
import com.bit.blog.pojo.dataobject.BlogInfo;
import com.bit.blog.pojo.dataobject.UserInfo;
import com.bit.blog.pojo.request.UserLoginRequest;
import com.bit.blog.pojo.response.UserInfoResponse;
import com.bit.blog.pojo.response.UserloginResponse;
import com.bit.blog.service.BlogInfoService;
import com.bit.blog.service.UserInfoService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserInfoServiceimpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Resource(name = "blogInfoServiceimpl")
    private BlogInfoService blogInfoService;
    @Override
    public UserloginResponse checkPassword(UserLoginRequest userLoginRequest) {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getUserName,userLoginRequest.getUserName())
                .eq(UserInfo::getDeleteFlag,0);
        //查询数据库
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if(userInfo==null){
            //用户不存在
            System.out.println("用户不存在");
            throw new BlogException("用户不存在");

        }
        //判断密码是否正确
//        if(!userLoginRequest.getPassword().equals(userInfo.getPassword())){
//            System.out.println("密码错误");
//            throw new BlogException("用户密码错误");
//        }
        if(!SecurityUtil.verify(userLoginRequest.getPassword(),userInfo.getPassword())){
            throw new BlogException("用户密码错误");
        }
        //密码正确
        Map<String,Object> map=new HashMap<>();
        map.put("id",userInfo.getId());
        map.put("name",userInfo.getUserName());
        String token= JwtUtils.genToken(map);
        //UserloginResponse response=new UserloginResponse();
        return new UserloginResponse(userInfo.getId(),token);
    }

    @Override
    public UserInfoResponse getUserInfo(Integer userId) {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getDeleteFlag,0)
                .eq(UserInfo::getId,userId);
        UserInfo userInfo=userInfoMapper.selectOne(queryWrapper);
        return BeanTransUtils.trans(userInfo);
    }

    @Override
    public UserInfoResponse getAuthorInfo(Integer blogId) {
        //1.根据blogId 获取博客信息（包括作者ID）
        BlogInfo blogInfo =blogInfoService.getBlogInfo(blogId);
        if(blogInfo==null || blogInfo.getUserId()<=0){
            throw new BlogException("博客不存在");
        }
        //2.根据作者ID，获取作者信息
        return getUserInfo(blogInfo.getUserId());
    }
}


























