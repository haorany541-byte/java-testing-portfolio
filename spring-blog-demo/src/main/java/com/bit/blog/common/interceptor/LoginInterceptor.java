package com.bit.blog.common.interceptor;

import com.bit.blog.common.constant.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userToken=request.getHeader(Constants.USER_TOKEN_HEADER_KEY);
        log.info("从header获取token:"+userToken);
        if(userToken==null || userToken.isEmpty()){

            response.setStatus(401);

            return false;

        }
//        if(userToken==null){
//            //拦截
//            response.setStatus(401);
//            return false;
//
//
//        }
        //校验Token是否合法
        //if()
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }
}
