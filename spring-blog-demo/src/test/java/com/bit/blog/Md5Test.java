package com.bit.blog;

import com.bit.blog.common.util.SecurityUtil;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Md5Test {
    @Test
    public void encrypt(){
        String password="123456";
//        String s= DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
//        System.out.println(s);
        //System.out.println(UUID.randomUUID().toString().replace("-",""));
        String salt=UUID.randomUUID().toString().replace("-","");
        System.out.println(salt);
        String s2=DigestUtils.md5DigestAsHex((salt+password).getBytes(StandardCharsets.UTF_8));
        System.out.println(s2);
    }
    @Test
    public void check(){
        String sqlPassword="51bdf289a61544d2a1538041535e8eb8409c61d8cfeef41b048bd6bfe10df3cb";

        String inputPassword="123456";
        String salt=sqlPassword.substring(0,32);
        String s = DigestUtils.md5DigestAsHex((salt + inputPassword).getBytes(StandardCharsets.UTF_8));
        System.out.println(sqlPassword.equals(salt+s));
    }

    @Test
    void test(){
        String encrypt= SecurityUtil.encrypt("123456");
        boolean verify=SecurityUtil.verify("123456",encrypt);
        System.out.println(encrypt);

        System.out.println(verify);

    }
}
