package br.com.pizzaplaza.authservice.strategies;

import br.com.pizzaplaza.authservice.interfaces.UserStrategy;
import br.com.pizzaplaza.authservice.repository.ClientRepository;
import br.com.pizzaplaza.authservice.repository.UserRepository;
import br.com.pizzaplaza.entity.dto.UserDto;
import br.com.pizzaplaza.entity.systemactor.Client;
import br.com.pizzaplaza.entity.systemactor.User;
import br.com.pizzaplaza.util.PasswordUtil;
import io.vertx.core.cli.InvalidValueException;
import io.vertx.core.cli.Option;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClientStrategy implements UserStrategy {

    @Inject
    UserRepository userRepository;

    @Inject
    ClientRepository clientRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        if (!isUserDtoValid(userDto)) {
            throw new InvalidValueException(new Option(),"Usuário inválido");
        }

        User user = new User();

        user.setEmail(userDto.email);
        user.setPassword(PasswordUtil.hash(userDto.password));
        user.setAuthenticated(false);

        userRepository.save(user);

        Client client = new Client();

        client.setUser(user);;
        client.setCpf(userDto.getCpf());
        client.setName(userDto.getName());

        clientRepository.save(client);

        userDto.link = "http://localhost:8081/user/"+ user.getOid();

        return userDto;
    }

    @Override
    public boolean supports(String userType) {
        return "CLIENT".equals(userType);
    }

    public Boolean isUserDtoValid(UserDto userDto) {
        if (userDto == null) {
            return false;
        }

        if (!isEmailValid(userDto.email)) {
            return false;
        }

        if (!isPasswordValid(userDto.password)) {
            return false;
        }

        if (!isCpfValid(userDto.cpf)) {
            return false;
        }

        return true;
    }

    public Boolean isPasswordValid(String password) {
        return password != null && !password.isEmpty() && !password.isBlank();
    }

    public Boolean isEmailValid(String email) {
        return email != null && !email.isEmpty() && !email.isBlank();
    }

    public Boolean isCpfValid(String cpf) {
        return cpf != null && !cpf.isEmpty() && !cpf.isBlank();
    }
}
