package com.bit.blog.common.advice;

import com.bit.blog.common.exception.BlogException;
import com.bit.blog.pojo.response.Result;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@ResponseBody
@ControllerAdvice
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler
    public Result exceptionHandler(Exception exception){
        log.error("发生异常,e:",exception);
        return Result.fail(exception.getMessage());
    }
    @ExceptionHandler
    public Result exceptionHandler(BlogException exception){
        log.error("发生异常,e:",exception);
        return Result.fail(exception.getMessage());
    }
    @ExceptionHandler
    public Result exceptionHandler(ConstraintViolationException exception){
        //方法参数本身校验失败
        log.error("发生异常，e:{}",exception.getMessage());
        return Result.fail("参数校验失败");
    }
    @ExceptionHandler
    public Result exceptionHandler(MethodArgumentNotValidException exception){
        //JSON请求体里面的对象校验失败。
        //TODO 空指针自行处理
        String msg=exception.getBindingResult().getFieldError().getDefaultMessage();
        log.error("发生异常，e:{}",exception.getMessage());
        return Result.fail(msg);
    }
    @ExceptionHandler(HandlerMethodValidationException.class)
    public Result exceptionHandler(
            HandlerMethodValidationException exception){

        log.error("发生异常,e:",exception);

        return Result.fail("参数校验失败");

    }






















}
