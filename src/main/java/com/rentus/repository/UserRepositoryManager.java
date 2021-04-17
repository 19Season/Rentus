package com.rentus.repository;

import com.rentus.models.User;
import com.rentus.utility.SessionFactory;

import javax.persistence.EntityManager;


public class UserRepositoryManager implements UserRepository{
    private static org.hibernate.SessionFactory sessionFactory;
    private EntityManager session;

    public UserRepositoryManager() {
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void register(User user) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }


    @Override
    public User get(String userName, String password) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        User user = session.createNamedQuery("getByUserName", User.class)
                .setParameter("username", userName)
                .getSingleResult();
        session.getTransaction().commit();
        user.setAuthenticated(user.getPassword().equals(user.getPassword()));
        return user;

    }
}
