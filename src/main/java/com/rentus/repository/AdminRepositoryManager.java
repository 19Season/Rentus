package com.rentus.repository;

import com.rentus.utility.SessionFactory;
import com.rentus.models.Admin;

import javax.persistence.EntityManager;

public class AdminRepositoryManager implements AdminRepository {

    private static org.hibernate.SessionFactory sessionFactory;
    private EntityManager session;

    public AdminRepositoryManager() {
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void register(Admin admin) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        session.persist(admin);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public boolean login(Admin admin) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        Admin admin1 = session.createNamedQuery("adminLogin", Admin.class)
                .setParameter("username", admin.getUsername())
                .getSingleResult();
        session.getTransaction().commit();
        if (admin1.getPassword().equals(admin.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}


