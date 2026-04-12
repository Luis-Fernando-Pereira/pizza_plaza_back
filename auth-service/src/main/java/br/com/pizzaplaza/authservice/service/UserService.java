package br.com.pizzaplaza.authservice.service;

import br.com.pizzaplaza.authservice.interfaces.UserStrategy;
import br.com.pizzaplaza.entity.dto.UserDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Inject
    Instance<UserStrategy> strategies;

    @Transactional
    public UserDto save(UserDto userDto) {
        return strategies.stream()
                .filter(s -> s.supports(userDto.userType.name()))
                .findFirst()
                .orElseThrow()
                .save(userDto);
    }

}
