package br.com.pizzaplaza.entity.systemactor;

import br.com.pizzaplaza.entity.fatherofall.Odin;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends Odin {

    @Column
    private String name;

    @Column
    private String cpf;

}
