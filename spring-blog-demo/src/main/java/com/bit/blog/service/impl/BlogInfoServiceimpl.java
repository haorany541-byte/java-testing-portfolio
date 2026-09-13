package com.bit.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bit.blog.common.constant.Constants;
import com.bit.blog.common.exception.BlogException;
import com.bit.blog.common.util.BeanTransUtils;
import com.bit.blog.mapper.BlogInfoMapper;
import com.bit.blog.pojo.dataobject.BlogInfo;
import com.bit.blog.pojo.request.AddBlogRequest;
import com.bit.blog.pojo.request.UpdateBlogRequest;
import com.bit.blog.pojo.response.BlogInfoResponse;
import com.bit.blog.service.BlogInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class BlogInfoServiceimpl implements BlogInfoService {
    //放到常量类里
//    private static final Integer BLOG_DELETE =1;
//    private static final Integer BLOG_NOMAL=0;

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    public List<BlogInfoResponse> getList() {
        QueryWrapper<BlogInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag, Constants.BLOG_NOMAL);
        List<BlogInfo> blogInfos = blogInfoMapper.selectList(queryWrapper);
        //return blogInfos;
        List<BlogInfoResponse> blogInfoResponses=blogInfos.stream()
                .map(blogInfo-> BeanTransUtils.trans(blogInfo))
//            BlogInfoResponse response=new BlogInfoResponse();
//            BeanUtils.copyProperties(blogInfo,response);
//            return response;
         .collect(Collectors.toList());
        return blogInfoResponses;
    }

    @Override
    public BlogInfoResponse getBlogDetail(Integer blogId) {

//        QueryWrapper<BlogInfo> queryWrapper=new QueryWrapper<>();
//        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag,0)
//                        .eq(BlogInfo::getId,blogId);
//        BlogInfo blogInfo = blogInfoMapper.selectOne(queryWrapper);
//        BlogInfoResponse response=new BlogInfoResponse();
//        BeanUtils.copyProperties(blogInfo,response);
        //return response;
        return BeanTransUtils.trans(getBlogInfo(blogId));
    }

    @Override
    public BlogInfo getBlogInfo(Integer blogId){
        QueryWrapper<BlogInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag,Constants.BLOG_NOMAL)
                .eq(BlogInfo::getId,blogId);
        return blogInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public Boolean addBlog(AddBlogRequest addBlogRequest) {
        BlogInfo blogInfo=new BlogInfo();
        BeanUtils.copyProperties(addBlogRequest,blogInfo);
        try{
            Integer result=blogInfoMapper.insert(blogInfo);
            if(result==1){
                return true;
            }
            return false;
        }catch (Exception e){
            log.error("博客插入失败,e:",e);
            throw new BlogException("内部错误，请联系管理员");
        }

    }

    @Override
    public Boolean updateBlog(UpdateBlogRequest updateBlogRequest) {
        BlogInfo blogInfo=BeanTransUtils.trans(updateBlogRequest);
        try{
            Integer result=blogInfoMapper.updateById(blogInfo);
            return result==1;
        }catch (Exception e){
            log.error("更新博客失败，e:",e);
            throw new BlogException("内部错误，请联系管理员");
        }
    }

    @Override
    public Boolean deleteBlog(Integer blogId) {
        BlogInfo blogInfo=new BlogInfo();
        blogInfo.setId(blogId);
        blogInfo.setDeleteFlag(Constants.BLOG_DELETE);
        try{
            Integer result=blogInfoMapper.updateById(blogInfo);
            return result==1;
        }catch (Exception e){
            log.error("删除博客失败，e:",e);
            throw new BlogException("内部错误，请联系管理员");
        }
    }
}

































