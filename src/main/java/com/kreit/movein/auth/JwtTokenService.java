package com.kreit.movein.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class JwtTokenService {
    private static final Key appUserJwtKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final Key agentJwtKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String createAppUserAuthenticationJwt(int appUserId, int expirationInMilliSeconds) {
        return createJwt(Map.of("id", appUserId), expirationInMilliSeconds, appUserJwtKey);
    }

    public static String createAgentUserAuthenticationJwt(int appUserId, int expirationInMilliSeconds) {
        return createJwt(Map.of("id", appUserId), expirationInMilliSeconds, agentJwtKey);
    }

    public static Claims getAppUserTokenClaims(String token) {
        try {
            // JWT 토큰 검증
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(appUserJwtKey)
                    .build()
                    .parseClaimsJws(token);

            // 토큰 유효성 검사 및 클레임(Claims) 추출
            Claims claims = claimsJws.getBody();
            String subject = claims.getSubject();
            return claims;
        } catch (Exception e) {
            System.err.println("Invalid Token: " + e.getMessage());
            throw e;
        }
    }

    public static Claims getAgentUserTokenClaims(String token) {
        try {
            // JWT 토큰 검증
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(agentJwtKey)
                    .build()
                    .parseClaimsJws(token);

            // 토큰 유효성 검사 및 클레임(Claims) 추출
            Claims claims = claimsJws.getBody();
            String subject = claims.getSubject();
            return claims;
        } catch (Exception e) {
            System.err.println("Invalid Token: " + e.getMessage());
            throw e;
        }
    }

    private static String createJwt(Map<String, Object> claims, int expirationInMilliSeconds, Key key) {
        // 페이로드(Claims) 생성
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationInMilliSeconds); // 1 hour
        String subject = "authentication";

        // JWT 토큰 생성
        String token = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .addClaims(claims)
                .signWith(key)
                .compact();

        return token;
    }
}
