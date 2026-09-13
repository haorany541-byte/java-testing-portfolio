package com.bit.blog.controller;

import com.bit.blog.pojo.dataobject.BlogInfo;
import com.bit.blog.pojo.request.AddBlogRequest;
import com.bit.blog.pojo.request.UpdateBlogRequest;
import com.bit.blog.pojo.response.BlogInfoResponse;
import com.bit.blog.service.BlogInfoService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Validated
@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogInfoController {
    @Resource(name="blogInfoServiceimpl")
    private BlogInfoService blogInfoService;
    @RequestMapping("/getList")
    public List<BlogInfoResponse> getList(){
        log.info("获取博客列表...");
        List<BlogInfoResponse> blogInfoResponses=blogInfoService.getList();
        return blogInfoResponses;
    }

    /**
     * 获取博客详情
     * @param blogId 博客ID
     * @return 博客详情
     */
    @RequestMapping("/getBlogDetail")
    public BlogInfoResponse getBlogDetail(@NotNull Integer blogId){
        log.info("获取博客详情，blogId:{}",blogId);
        return blogInfoService.getBlogDetail(blogId);


    }
    /**
     * 添加博客
     */
    @RequestMapping("/add")
    public Boolean addBlog(@RequestBody AddBlogRequest addBlogRequest){
        log.info("发布博客，userId:{},title{}",addBlogRequest.getUserId(),addBlogRequest.getTitle());
        return blogInfoService.addBlog(addBlogRequest);
    }

    /**
     * 编辑博客
     */
    @RequestMapping("/update")
    public Boolean update(@RequestBody UpdateBlogRequest updateBlogRequest){
            log.info("更新博客，request:{}", updateBlogRequest);
            return blogInfoService.updateBlog(updateBlogRequest);
        }


    /**
     * 删除博客
     */
    @RequestMapping("/delete")
    public Boolean delete(@NotNull(message = "id不能为null") Integer blogId){
        log.info("删除博客，id:", blogId);
        return blogInfoService.deleteBlog(blogId);
    }
}















