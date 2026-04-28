package br.com.pizzaplaza.userservice.interfaces;

import br.com.pizzaplaza.entity.dto.UserDto;

public interface UserStrategy {
    public UserDto save(UserDto userDto);
    boolean supports(String userType);
}
