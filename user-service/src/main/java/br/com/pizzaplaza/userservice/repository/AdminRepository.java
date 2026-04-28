package br.com.pizzaplaza.userservice.repository;

import br.com.pizzaplaza.entity.systemactor.Admin;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

@ApplicationScoped
public class AdminRepository {

    @Inject
    EntityManager em;

    public Admin save(Admin admin) {
        em.persist(admin);
        return admin;
    }

    public List<Admin> findAll() {
        Query query = em.createQuery("select a from Admin a");

        List<Admin> results = query.getResultList();

        return results;
    }
}
