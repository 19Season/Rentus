package com.rentus.services;

import com.rentus.models.Product;

import java.util.List;


public interface ProductService {
    List<Product> getProducts();
    List<Product> getBookedProducts();
    boolean update(Product product);
    //void orderTool(Tool tool);
    void create(Product product);
    Product findById(int id);
   List<Product> findByCategories(String type);
   void delete(Product product);

    }