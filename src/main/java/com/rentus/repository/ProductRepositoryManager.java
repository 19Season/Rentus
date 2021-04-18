package com.rentus.repository;

import com.rentus.models.Product;
import com.rentus.utility.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductRepositoryManager implements ProductRepository {
    
    private static org.hibernate.SessionFactory sessionFactory;
    private EntityManager session;

    public ProductRepositoryManager() {
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public List<Product> allProducts() {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        List<Product> result = session.createQuery("FROM Tool t INNER JOIN FETCH t.shop s").getResultList();
//        List<Tool> result = session.createQuery("FROM Tool").getResultList();

        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }


    @Override
    public List<Product> getAllBookedProducts() {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        List<Product> result = session.createNamedQuery("getBooked", Product.class)
                .setParameter("booked",true)
                .getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

    @Override
        public void delete(Product product) {
            session = sessionFactory.createEntityManager();
            session.getTransaction().begin();
//            Product product = session.find(Product.class, product);
            session.remove(product);
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }


    }

    @Override
    public void create(Product product) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        session.persist(product);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public boolean update(Product product) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
//        Product product = session.find(Product.class,id);
//        product.setName(product.getName());
//        product.setPrice(product.getPrice());
//        product.setDescription(product.getDescription());
//        product.setType(product.getType());
//        product.setSize(product.getSize());
//        product.setId(id);
        session.merge(product);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return true;
    }



    @Override
    public Product getById(int id) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        Product tools1 = session.find(Product.class,id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return tools1;

    }

    @Override
    public List<Product> getByCategories(String type) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        List<Product> tools1 = session.createNamedQuery("getCategory", Product.class).
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
