package com.rentus.repository;

import com.rentus.models.Tools;
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
    public void addTool(Tools tool) {
            session = sessionFactory.createEntityManager();
            session.getTransaction().begin();
            session.persist(tool);
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }


    }

    @Override
    public List<Tools> allTools() {

        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }



    @Override
    public void getById() {

    }

    @Override
    public void getByType() {

    }

    @Override
    public void Available() {

    }
}
