package br.com.pizzaplaza.authservice.service;

import br.com.pizzaplaza.authservice.repository.UserRepository;
import br.com.pizzaplaza.entity.dto.LoginDto;
import br.com.pizzaplaza.entity.systemactor.User;
import br.com.pizzaplaza.util.PasswordUtil;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class AuthService {

    @Inject
    UserRepository userRepository;

    public String generateJwt(User user) {
        Set<String> roles = new HashSet<>(
                Arrays.asList("admin", "seller"));

        long duration = System.currentTimeMillis() + 3600;

        return Jwt.issuer("auth-service")
                .subject(user.getOid())
                .groups(roles)
                .expiresAt(duration)
                .sign();
    }

    public User authenticate(LoginDto loginData) {

        User user = userRepository.findByEmail(loginData.email);

        if (user == null) {
            return null;
        }

        if (!PasswordUtil.isPasswordValid(loginData.password, user.getPassword())) {
            return null;
        }

        user.setAuthenticated(true);

        user = userRepository.update(user);

        return user;
    }
}
