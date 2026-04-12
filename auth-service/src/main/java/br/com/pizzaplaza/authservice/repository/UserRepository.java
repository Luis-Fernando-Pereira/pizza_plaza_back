package br.com.pizzaplaza.authservice.repository;

import br.com.pizzaplaza.entity.systemactor.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@ApplicationScoped
public class UserRepository {

    @Inject
    EntityManager em;

    public User save(User user) {
        em.persist(user);
        return user;
    }

    public User findByEmail(String email) {
        return em.createQuery("SELECT u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public User update(User user) {
        return em.merge(user);
    }
}
