package br.com.pizzaplaza.entity.systemactor;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="admin")
public class Admin extends Person {

    @OneToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;
}
