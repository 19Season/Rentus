package com.rentus.repository;

import com.rentus.models.Client;
import com.rentus.utility.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;


public class ClientRepositoryManager implements ClientRepository {
    private static org.hibernate.SessionFactory sessionFactory;
    private EntityManager session;

    public ClientRepositoryManager() {
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void Register(Client client) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        session.persist(client);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }


    }


    @Override
    public Client Login(Client client) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        Client client1 = session.createNamedQuery("login", Client.class)
                .setParameter("username", client.getUsername())
                .getSingleResult();
//        System.out.println(client1);
        session.getTransaction().commit();
        if (client1.getPassword().equals(client.getPassword())) {
            return client1;
        } else {
            return null;
        }


    }


    @Override
    public List<Client> allClients() {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        // List<Product> result = session.createQuery("FROM Product t INNER JOIN FETCH t.shop s").getResultList();
        List<Client> result = session.createQuery("FROM Client").getResultList();

        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }
}
