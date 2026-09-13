package com.bit.blog;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    void genToken(){
        //Key key= Keys.hmacShaKeyFor("123456".getBytes(StandardCharsets.UTF_8));
        Key key=Keys.secretKeyFor(SignatureAlgorithm.HS256);
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",12);
        claims.put("name","zhangsan");
        String jwt=Jwts.builder()
                .setClaims(claims)
                .signWith(key)
                .compact();
        System.out.println(jwt);
        JwtParser build=Jwts.parserBuilder().setSigningKey(key).build();
        System.out.println(build.parse(jwt+"111111").getBody());
    }
}






















