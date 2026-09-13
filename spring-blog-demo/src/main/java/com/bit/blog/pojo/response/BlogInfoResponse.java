package com.bit.blog.pojo.response;

import com.bit.blog.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BlogInfoResponse {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    //@JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime createTime;
    public String getCreateTime(){
        return DateUtils.dateFormat(createTime);
    }
//    public String getContent(){
//        return content==null?"":content.substring(0,50);
//    }
}
