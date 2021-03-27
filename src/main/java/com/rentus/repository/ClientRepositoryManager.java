package com.rentus.repository;

import com.rentus.models.Client;
import com.rentus.utility.SessionFactory;

import javax.persistence.EntityManager;


public class ClientRepositoryManager implements ClientRepository{
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
    public void Login(Client client) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        Client Clients1 = session.createQuery("Login", Client.class)
                .setParameter("Username", client.getUsername())
                .getSingleResult();
        session.getTransaction().commit();
    }


    }

