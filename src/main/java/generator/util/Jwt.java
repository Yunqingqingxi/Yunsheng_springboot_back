package generator.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * jwt token令牌
 */
public class Jwt {

    // 密钥
    private static final String APP_SECRET = "ukc323BDbRigUDaY6pZFfWus2jZWLPHO";

    /**
     * 生成token
     *
     * @param id
     * @return String
     */
    public static String createToken(Long id) {
        Date now = new Date();
        Date date = new Date(now.getTime() + 1000 * 60 * 60);
        return JWT.create()
                .withClaim("id", id)
                .withIssuedAt(now)//签发时间
                .withExpiresAt(date)//过期时间
                .sign(Algorithm.HMAC256(APP_SECRET));

    }

    /**
     * 获取token中的id
     * @param token
     * @return
     */
    public static Long getIdfromToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("id").asLong();
    }

    /**
     * 验证token
     */
    public static DecodedJWT verify(String token) {
        // 如果有任何验证异常，此处都会抛出异常
        return JWT.require(Algorithm.HMAC256(APP_SECRET)).build().verify(token);
    }
}
