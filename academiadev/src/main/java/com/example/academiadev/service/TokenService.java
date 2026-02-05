package com.example.academiadev.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.academiadev.model.Aluno;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String tokenSecret;

    private static final String ISSUER = "auth-api";
    private static final int EXPIRATION_TIME = 2;
    private static final ZoneOffset TIMEZONE_OFFSET = ZoneOffset.of("-03:00");

    public String generateToken(Aluno aluno) {
        try {
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(aluno.getUsername())
                    .withExpiresAt(getExpirationInstant())
                    .sign(getSigningAlgorithm());
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Could not generate token", ex);
        }
    }

    public String validateToken(String token) {
        try {
            return JWT.require(getSigningAlgorithm())
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            return null;
        }
    }

    private Algorithm getSigningAlgorithm() {
        return Algorithm.HMAC256(tokenSecret);
    }

    private Instant getExpirationInstant() {
        return LocalDateTime.now()
                .plusHours(EXPIRATION_TIME)
                .toInstant(TIMEZONE_OFFSET);
    }

}
