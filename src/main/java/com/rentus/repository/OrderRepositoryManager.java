
package com.rentus.repository;

import com.rentus.models.Order;
import com.rentus.models.Tool;
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
        Tool tool = session.find(com.rentus.models.Tool.class, order.getTool().getId());
        tool.setBooked(true);
        session.persist(tool);

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
        Tool tool = order.getTool();
        tool.setBooked(false);
        session.remove(order);
        session.persist(tool);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return true;
    }

    @Override
    public List<Order> getallOrders() {
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



