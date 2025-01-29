package com.da.innercrud1.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface JWTService {
    String extractUsername(String token);
    String generateToken(UserDetails userDetails);
    boolean IsTokenValid(String token, UserDetails userDetails);
    String generateRefreshToken(Map<String, Object> extractClaims, UserDetails userDetails);

}