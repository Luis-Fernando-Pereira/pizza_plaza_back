package br.com.pizzaplaza.entity.systemactor;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Table
public class Client extends Person {

    @JoinColumn(name="user_id")
    private User user;

}
