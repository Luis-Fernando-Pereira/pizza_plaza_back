package br.com.pizzaplaza.entity.systemactor;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client extends Person {

    @OneToOne
    @JoinColumn(name="user_id")
    public User user;

}
