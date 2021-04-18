package com.rentus.repository;

import com.rentus.models.Product;

import java.util.List;

public interface ProductRepository {

      void create(Product product);
      List<Product> allProducts();
      List<Product> getAllBookedProducts();
      void delete(Product product);
      boolean update(Product tools);
      Product getById(int id);
      List<Product> getByCategories(String type);
      void Available();
      //boolean cancelBook(int id);

  }
