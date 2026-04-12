package br.com.pizzaplaza.entity.dto;


import br.com.pizzaplaza.entity.fatherofall.OdinDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto extends OdinDto {
    public String name;
    public String cpf;

    @Email(message = "Email inválido")
    public String email;

    @Size(message = "Senha deve ter no mínimo 18 caracteres", min = 18)
    public String password;
    public Type userType;

    public enum Type {ADMIN, CLIENT, SELLER}
}
