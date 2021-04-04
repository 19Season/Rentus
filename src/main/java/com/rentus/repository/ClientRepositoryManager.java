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
    public boolean Login(Client client) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        Client client1 = session.createNamedQuery("login", Client.class)
                .setParameter("username", client.getUsername())
                .getSingleResult();
        session.getTransaction().commit();
        if(client1.getPassword().equals(client.getPassword()))
        {return true;
        }
        else{
            return false;
        }


    }
}
