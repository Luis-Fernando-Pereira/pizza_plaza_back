package br.com.pizzaplaza.authservice;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class AuthService {

    public String generateJwt() {
        Set<String> roles = new HashSet<>(
                Arrays.asList("admin", "seller"));

        long duration = System.currentTimeMillis() + 3600;

        return Jwt.issuer("auth-service")
                .subject("auth-service")
                .groups(roles)
                .expiresAt(duration)
                .sign();
    }
}
