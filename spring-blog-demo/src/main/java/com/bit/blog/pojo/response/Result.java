package com.bit.blog.pojo.response;

import com.bit.blog.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result {
    private ResultCodeEnum code;//业务状态码 非HTTP状态码
    private String errMsg;
    private Object data;
    public static Result success(Object data){
        Result result=new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }
    public static Result fail(String errMsg){
        Result result=new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(errMsg);
        return result;

    }
}
