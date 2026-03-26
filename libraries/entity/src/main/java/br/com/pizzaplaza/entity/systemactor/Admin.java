package br.com.pizzaplaza.entity.systemactor;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Table
public class Admin extends Person {

    @JoinColumn(name="user_id",nullable = false)
    private User user;
}
