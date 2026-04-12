package br.com.pizzaplaza.entity.systemactor;

import br.com.pizzaplaza.entity.fatherofall.Odin;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class Person extends Odin {

    @Column
    public String name;

}
