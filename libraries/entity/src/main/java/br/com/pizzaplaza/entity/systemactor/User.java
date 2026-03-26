package br.com.pizzaplaza.entity.systemactor;

import br.com.pizzaplaza.entity.fatherofall.Odin;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table
public class User extends Odin {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean authenticated;

    public String toString() {
        return "Usuário" + this.email + super.toString();
    }
}
