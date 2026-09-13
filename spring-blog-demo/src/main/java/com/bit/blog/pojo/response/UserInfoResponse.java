package com.bit.blog.pojo.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInfoResponse {
    private Integer id;
    private String userName;
    private String githubUrl;

}
