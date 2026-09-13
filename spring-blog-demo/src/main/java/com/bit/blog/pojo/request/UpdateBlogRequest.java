package com.bit.blog.pojo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBlogRequest {
    @NotNull(message = "ID不能为空")
    private Integer id;
    private String title;
    private String content;
}
