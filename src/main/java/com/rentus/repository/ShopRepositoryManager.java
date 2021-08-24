package com.rentus.repository;

import com.rentus.models.Shop;
import com.rentus.utility.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

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
    public Shop login(Shop shop) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        Shop shop1 = session.createNamedQuery("findShopUsername", Shop.class)
                .setParameter("username", shop.getUsername())
                .getSingleResult();
        session.getTransaction().commit();
        if (shop1.getPassword().equals(shop.getPassword())) {
            return shop1;
        } else {
            return null;

        }

    }

    @Override
    public List<Shop> allShops() {
            session = sessionFactory.createEntityManager();
            session.getTransaction().begin();
            // List<Product> result = session.createQuery("FROM Product t INNER JOIN FETCH t.shop s").getResultList();
            List<Shop> result = session.createQuery("FROM Shop").getResultList();

            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
            return result;
        }
    }


