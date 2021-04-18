package com.rentus.utility;

import com.rentus.services.*;

public class RepoFactory {


    public static ShopRepository getShopRepo(){
        return new ShopRepositoryManager();
    }

    public static ProductRepository getProductRepo() {
        return new ProductRepositoryManager();
    }

    public static ClientRepository getClientRepo() {
        return new ClientRepositoryManager();

    }

    public static UserRepository getUserRepo() {
        return new UserRepositoryManager();

    }
public static AdminRepository getAdminRepo(){
        return new AdminRepositoryManager();
}
public static OrderRepository getOrderRepo(){
        return new OrderRepositoryManager();
}
    }

