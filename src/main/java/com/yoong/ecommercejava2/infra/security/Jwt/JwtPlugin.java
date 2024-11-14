package com.yoong.ecommercejava2.infra.security.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsBuilder;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtPlugin {

    @Value("${auth.jwt.issuer}")
    private String issuer;

    @Value("${auth.jwt.secret}")
    private String secret;

    @Value("${auth.jwt.accessTokenExpirationHour}")
    private long accessTokenExpirationHour;


    public Jws<Claims> validateToken(String jwt){

        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        return Jwts.parser().verifyWith(key).build().parseSignedClaims(jwt);
    }

    public String generateAccessToken(String subject, String email, String role){

        return generateToken(subject, email, role, Duration.ofHours(accessTokenExpirationHour));
    }

    public String generateToken(String subject, String email, String role, Duration expirationPeriod){

        Instant now = Instant.now();
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .subject(subject)
                .issuer(issuer)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(expirationPeriod)))
                .claim("role", role)
                .claim("email", email)
                .signWith(key)
                .compact();

    }
}