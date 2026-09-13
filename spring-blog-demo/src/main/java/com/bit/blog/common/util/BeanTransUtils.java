package com.bit.blog.common.util;

import com.bit.blog.pojo.dataobject.BlogInfo;
import com.bit.blog.pojo.dataobject.UserInfo;
import com.bit.blog.pojo.request.UpdateBlogRequest;
import com.bit.blog.pojo.response.BlogInfoResponse;
import com.bit.blog.pojo.response.UserInfoResponse;
import org.springframework.beans.BeanUtils;

public class BeanTransUtils {
    public static BlogInfoResponse trans(BlogInfo blogInfo){
        if(blogInfo==null){
            //TODO
            //标识要写但还没写的事情
            return null;
        }
        BlogInfoResponse response=new BlogInfoResponse();
        org.springframework.beans.BeanUtils.copyProperties(blogInfo,response);
        return response;
    }
    public static UserInfoResponse trans(UserInfo userInfo){
        if(userInfo==null){
            //TODO
            //标识要写但还没写的事情
            return null;
        }
        UserInfoResponse userInfoResponse=new UserInfoResponse();
        BeanUtils.copyProperties(userInfo,userInfoResponse);
        return userInfoResponse;
    }

    public static BlogInfo trans(UpdateBlogRequest updateBlogRequest){
        if(updateBlogRequest==null){
            return null;
        }
        BlogInfo blogInfo=new BlogInfo();
        BeanUtils.copyProperties(updateBlogRequest,blogInfo);
        return blogInfo;
    }
}
