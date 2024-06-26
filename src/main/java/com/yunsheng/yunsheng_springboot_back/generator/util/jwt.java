package com.yunsheng.yunsheng_springboot_back.generator.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class jwt {

    private static final String key = "jile14779835797";

    public static String createToken(Long id) {
        Date now = new Date();
        Date date = new Date(now.getTime() + 1000 * 60 * 60);
        return JWT.create()
                .withClaim("id", id)
                .withIssuedAt(now)//签发时间
                .withExpiresAt(date)//过期时间
                .sign(Algorithm.HMAC256(key));

    }

    public static Long getIdfromToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("id").asLong();
    }


}
