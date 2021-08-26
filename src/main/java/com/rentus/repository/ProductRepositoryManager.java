package com.rentus.repository;

import com.rentus.models.Client;
import com.rentus.models.Product;
import com.rentus.models.Shop;
import com.rentus.utility.RepoFactory;
import com.rentus.utility.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductRepositoryManager implements ProductRepository {

    private static org.hibernate.SessionFactory sessionFactory;
    private EntityManager session;
    private ShopRepository shopRepo;

    public ProductRepositoryManager() {
        sessionFactory = SessionFactory.getInstance();
        this.shopRepo= RepoFactory.getShopRepo();
    }

    @Override
    public List<Product> allProducts() {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
       // List<Product> result = session.createQuery("FROM Product t INNER JOIN FETCH t.shop s").getResultList();
       List<Product> result = session.createQuery("FROM Product").getResultList();

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
                .setParameter("booked", true)
                .getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

    @Override
    public List<Product> getShopTools(int id) {
        System.out.println("Repo ..");
            session = sessionFactory.createEntityManager();
            session.getTransaction().begin();
            try {
                Shop shop =  shopRepo.getShopById(id);
                System.out.println(shop);
                List<Product> result = session.createNamedQuery("findByShopId", Product.class).setParameter("shop",shop).getResultList();
                session.getTransaction().commit();
                if (session.isOpen()) {
                    session.close();
                }
                System.out.println(result);
                return result;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }

@Override
    public List<Product> getClientBookedProduct(int id) {
        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        Client client = new Client();
        client.setId(id);
        List<Product> result = session.createNamedQuery("findByClient", Product.class).setParameter("client", client).getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

//    @Override
//    public boolean approveProduct(int id) {
//        return false;
//    }


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

