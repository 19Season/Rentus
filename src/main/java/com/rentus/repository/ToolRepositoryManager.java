package com.rentus.repository;

import com.rentus.models.Tool;
import com.rentus.utility.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class ToolRepositoryManager implements ToolRepository {
    
    private static org.hibernate.SessionFactory sessionFactory;
    private EntityManager session;

    public ToolRepositoryManager() {
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void addTool(Tool tool) {
            session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        session.persist(tool);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }


    }

    @Override
    public List<Tool> allTools() {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        List<Tool> result = session.createQuery("FROM Tool t INNER JOIN FETCH t.shop s").getResultList();
//        List<Tool> result = session.createQuery("FROM Tool").getResultList();

        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }


    @Override
    public List<Tool> getAllBookedTool() {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        List<Tool> result = session.createNamedQuery("getBooked",Tool.class)
                .setParameter("booked",true)
                .getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

    @Override
        public void delete(Tool tool) {
            session = sessionFactory.createEntityManager();
            session.getTransaction().begin();
            Tool tools1 = session.find(Tool.class,tool);
            session.remove(tools1);
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }


    }

    @Override
    public boolean update(int id, Tool tools) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        Tool tools1 = session.find(Tool.class,id);
        tools1.setName(tools.getName());
        tools1.setPrice(tools.getPrice());
        tools1.setDescription(tools.getDescription());
        tools1.setType(tools.getType());
        tools1.setSize(tools.getSize());
        tools1.setId(id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return true;
    }



    @Override
    public Tool getById(int id) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        Tool tools1 = session.find(Tool.class,id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return tools1;

    }

    @Override
    public List<Tool> getByCategories(String type) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        List<Tool> tools1 = session.createNamedQuery("getCategory",Tool.class).
                setParameter("type",type).getResultList();
                session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return tools1;

    }

    @Override
    public void Available() {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();

    }


    }

   /* @Override
    public boolean cancelBook(int id) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        Tool tools1 = session.find(Tool.class,id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return true;
    }*/

