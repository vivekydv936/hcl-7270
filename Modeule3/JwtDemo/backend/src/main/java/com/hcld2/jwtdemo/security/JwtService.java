package com.hcld2.jwtdemo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private final Algorithm algorithm;
    private final JWTVerifier jwtVerifier;
    private final long expireMs;
    public JwtService(@Value("${jwt.secret}") String secret,
                      @Value("${jwt.expire-ms}") long expireMs) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.jwtVerifier = JWT.require(algorithm).build();
        this.expireMs = expireMs;
    }

    public String generateToken(String username) {
        Date now = new Date();

        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(now.getTime() + expireMs))
                .sign(algorithm);
    }



    public String verifyAndGetUsername(String token) {
        try{
            return jwtVerifier.verify(token).getSubject();
        }
        catch (Exception e){
            return  null;
        }
    }

}
