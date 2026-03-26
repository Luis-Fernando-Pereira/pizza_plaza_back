package br.com.pizzaplaza.entity.fatherofall;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class Odin {

    @Id
    private Integer id;

    @Column
    private Integer idUserWhoCreated;

    @Column
    private Date createdAt;

    @Column
    private Integer idUserWhoChanged;

    @Column
    private Date changedAt;

    public String toString() {
        return "criado por usuário: " + this.idUserWhoCreated;
    }
}
