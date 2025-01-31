package com.da.innercrud1.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;


@Service
public class JWTServiceImpl implements JWTService {

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername())

                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+10000 * 60 * 24))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    public String generateRefreshToken(Map<String, Object> extractClaims, UserDetails userDetails) {
        return Jwts.builder().setClaims(extractClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 63000000))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){
        final Claims cLaims = extractAllClaims(token);
        return claimsResolvers.apply(cLaims);

    }

    public String extractUsername(String token){
        try {
            String username = extractClaim(token, Claims::getSubject);
            System.out.println(" Extracted username from JWT: " + username);
            return username;
        } catch (Exception e) {
            System.out.println(" Error extracting username from token: " + e.getMessage());
            return null;
        }
    }


    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSigninKey()).build()
                .parseClaimsJws(token).getBody();
    };

    private Key getSigninKey(){
        byte[] key = Decoders.BASE64.decode("31bd8eaf63640411cbaf1e7cace3b473ae36a76c79e857ba131b83807087220b");
        return Keys.hmacShaKeyFor(key);
    }
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        boolean isValid = username.equals(userDetails.getUsername()) && !isTokenExpired(token);

        System.out.println(" JWT Validation: ");
        System.out.println(" Extracted username: " + username);
        System.out.println(" Expected username: " + userDetails.getUsername());
        System.out.println(" Is token expired? " + isTokenExpired(token));
        System.out.println(" Is token valid? " + isValid);

        return isValid;
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());

    }
}


