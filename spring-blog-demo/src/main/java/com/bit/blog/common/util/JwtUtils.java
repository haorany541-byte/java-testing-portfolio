package com.bit.blog.common.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.val;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;


public class JwtUtils {


    private static final String SECRET_STRING =
            "dVnsmy+SIX6pNptQdeclDSJ26EMSPEIhvZYKBTTug4k=";


    private static final SecretKey KEY =
            Keys.hmacShaKeyFor(
                    Decoders.BASE64.decode(SECRET_STRING)
            );


    private static final long EXPIRATION =
            24 * 60 * 60 * 1000;


    public static String genToken(Map<String,Object> claims){

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis()+EXPIRATION)
                )
                .signWith(KEY)
                .compact();

    }


    public static Claims parseToken(String token){

        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();

    }
    public static void main(String[] args){
        String token="eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiemhhbmdzYW4iLCJpZCI6MSwiaWF0IjoxNzg1Mjk5OTgyLCJleHAiOjE3ODUzODYzODJ9.t83TLjFaCiK_er9WGKkxDu4SD7i4s3kaLkpjyCjKNxI";
        Claims claims = parseToken(token);
        System.out.println(claims);
    }
}