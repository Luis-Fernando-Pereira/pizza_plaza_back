package br.com.pizzaplaza.entity.systemactor;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client extends Person {

    @Column(unique = true)
    public String cpf;

    @OneToOne
    @JoinColumn(name="user_id")
    public User user;

}
