package br.com.pizzaplaza.authservice.service;

import br.com.pizzaplaza.authservice.interfaces.UserStrategy;
import br.com.pizzaplaza.authservice.strategies.AdminStrategy;
import br.com.pizzaplaza.authservice.strategies.ClientStrategy;
import br.com.pizzaplaza.authservice.strategies.SellerStrategy;
import br.com.pizzaplaza.entity.dto.UserDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService {

    private UserStrategy userStrategy;

    public void setStrategy(UserStrategy userStrategy) {
        this.userStrategy = userStrategy;
    }

    @Transactional
    public UserDto executeStrategy(UserDto userDto) {
        return this.userStrategy.save(userDto);
    }

    @Transactional
    public UserDto save(UserDto userDto) {

        if (UserDto.Type.ADMIN.equals(userDto.userType)) {
            this.setStrategy(new AdminStrategy());
        }

        if (UserDto.Type.CLIENT.equals(userDto.userType)) {
            this.setStrategy(new ClientStrategy());
        }

        if (UserDto.Type.SELLER.equals(userDto.userType)) {
            this.setStrategy(new SellerStrategy());
        }

        return this.executeStrategy(userDto);
    }

}
