package com.rentus.controllers;

import com.rentus.repository.ProductRepository;
import com.rentus.repository.ProductRepositoryManager;

import static spark.Spark.get;

public class TestController {
    private ProductRepository productRepo;

    public TestController(){}

    public TestController(ProductRepository productRepo) {
        this.productRepo = new ProductRepositoryManager();
    }

    public void test() {
        get("/test/:id", (req, res) -> {
            int id=Integer.parseInt(req.params("id"));
            System.out.println(id);
            return productRepo.getShopTools(id);
        });
    }
}
