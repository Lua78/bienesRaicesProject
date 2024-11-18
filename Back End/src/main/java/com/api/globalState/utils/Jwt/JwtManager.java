package com.api.globalState.utils.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtManager {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long tokenValidity;

    @Value("${jwt.expiration}")
    private long refreshTokenValidity;

    private Key key;

    @PostConstruct
    public void init() {
        byte[] encodedKey = Base64.decodeBase64(secret);
        this.key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "HmacSHA512");
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public String generateToken(Integer id, String username, String role) {
        return getToken(id, username, role, "access", tokenValidity);
    }

    public String getUsernameFromToken(String token) {
        return getAllClaimsFromToken(token).get("username").toString();
    }

    public Integer getIdFromToken(String token) {
        return Integer.parseInt(getAllClaimsFromToken(token).get("id").toString());
    }

    public boolean isTokenExpired(String token) {
        return this.getAllClaimsFromToken(token).getExpiration().before(new Date());
    }

    public String generateRefreshToken(Integer id, String username, String rol) {
        return getToken(id, username, rol, "refresh", refreshTokenValidity);
    }

    public boolean isThisRole(String token, String role) {
        Claims claims = this.getAllClaimsFromToken(token);
        return claims.get("role", String.class).equals(role);
    }

    public Long getExpirationDateFromToken(String token) {
        return this.getAllClaimsFromToken(token).getExpiration().getTime();
    }

    public String getRoleFromToken(String token) {
        return getAllClaimsFromToken(token).get("role").toString();
    }

    public String getTypeFromToken(String token) {
        return getAllClaimsFromToken(token).get("type").toString();
    }

    private String getToken(
            Integer id, String username, String rol, String refresh, long refreshTokenValidity) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);
        claims.put("username", username);
        claims.put("role", rol);
        claims.put("type", refresh);

        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + refreshTokenValidity;

        Date exp = new Date(expMillis);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(exp)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
}
