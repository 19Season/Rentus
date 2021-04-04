package com.rentus.repository;

import com.rentus.models.Shop;
import com.rentus.utility.SessionFactory;

import javax.persistence.EntityManager;

public class ShopRepositoryManager implements ShopRepository {
    private static org.hibernate.SessionFactory sessionFactory;
    private EntityManager session;

    public ShopRepositoryManager() {
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void register(Shop shop) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        session.persist(shop);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public Boolean login(Shop shop) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        Shop shop1 = session.createNamedQuery("findShopUsername", Shop.class)
                .setParameter("username", shop.getUsername())
                .getSingleResult();
        session.getTransaction().commit();
        if (shop1.getPassword().equals(shop.getPassword())) {
            return true;
        } else {
            return false;

        }

    }
}

