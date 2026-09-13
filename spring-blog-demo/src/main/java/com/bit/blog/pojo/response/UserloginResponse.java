package com.bit.blog.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class UserloginResponse {
    private Integer userId;
    private String token;
}
