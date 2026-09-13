package com.bit.blog.service;

import com.bit.blog.pojo.dataobject.BlogInfo;
import com.bit.blog.pojo.request.AddBlogRequest;
import com.bit.blog.pojo.request.UpdateBlogRequest;
import com.bit.blog.pojo.response.BlogInfoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogInfoService {
    List<BlogInfoResponse> getList();

    //BlogInfoResponse getBlogDatil(Integer blogId);

    BlogInfoResponse getBlogDetail(Integer blogId);

    BlogInfo getBlogInfo(Integer blogId);

    Boolean addBlog(AddBlogRequest addBlogRequest);

    Boolean updateBlog(UpdateBlogRequest updateBlogRequest);

    Boolean deleteBlog(Integer blogId);
}




















