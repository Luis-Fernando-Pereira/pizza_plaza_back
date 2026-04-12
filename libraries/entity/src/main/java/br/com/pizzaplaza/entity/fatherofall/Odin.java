package br.com.pizzaplaza.entity.fatherofall;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public class Odin {

    @Id
    @Column(length = 36)
    private String oid;

    @Column(name = "id_user_who_created")
    private String oidUserWhoCreated;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "id_user_who_changed")
    private String oidUserWhoChanged;

    @Column(name = "changed_at")
    private Date changedAt;

    @PrePersist
    public void beforePersist(){
        createdAt = new Date(System.currentTimeMillis());
        oid = UUID.randomUUID().toString();
    }

    public String toString() {
        return "criado por usuário: " + this.oidUserWhoCreated;
    }
}
