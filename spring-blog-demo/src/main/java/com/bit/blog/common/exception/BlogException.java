package com.bit.blog.common.exception;

import lombok.Data;

@Data
public class BlogException extends RuntimeException {


    private int code;

    private String errMsg;


    public BlogException(String errMsg) {

        super(errMsg);  //关键！！！

        this.errMsg = errMsg;

    }


    public BlogException(int code,String errMsg){

        super(errMsg);  //关键！！！

        this.code = code;
        this.errMsg = errMsg;

    }

}