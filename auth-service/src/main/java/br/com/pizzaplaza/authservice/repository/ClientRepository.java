package br.com.pizzaplaza.authservice.repository;

import br.com.pizzaplaza.entity.systemactor.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

@ApplicationScoped
public class ClientRepository {

    @Inject
    EntityManager em;

    public Client save(Client client) {
        em.persist(client);
        return client;
    }

    public List<Client> findAll() {
        Query query = em.createQuery("select c from Client c");

        List<Client> results = query.getResultList();

        return results;
    }
}
