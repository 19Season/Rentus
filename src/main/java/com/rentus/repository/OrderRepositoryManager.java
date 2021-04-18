
package com.rentus.repository;

import com.rentus.models.Order;
import com.rentus.models.Product;
import com.rentus.utility.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderRepositoryManager implements OrderRepository {
    private static org.hibernate.SessionFactory sessionFactory;
    private EntityManager session;

    public OrderRepositoryManager() {
        sessionFactory = SessionFactory.getInstance();
    }

    public boolean makeOrder(Order order) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        session.persist(order);
        Product product = session.find(Product.class, order.getProduct().getId());
        product.setBooked(true);
        session.persist(product);

        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return true;
    }

    @Override
    public boolean cancelOrder(int id) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        com.rentus.models.Order order = session.find(com.rentus.models.Order.class, id);
        Product product = order.getProduct();
        product.setBooked(false);
        session.remove(order);
        session.persist(product);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return true;
    }

    @Override
    public List<Order> getAllOrders() {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        List<Order> result = session.createNamedQuery("allOrders").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

    @Override
    public List<Order> getParticularOrder(int id) {
            session = sessionFactory.createEntityManager();
            session.getTransaction().begin();
            List<Order> orders = session.createNamedQuery("getParticularOrder").setParameter("client",id).getResultList();
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
            return orders;
        }
    }



