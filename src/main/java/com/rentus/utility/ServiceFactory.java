package com.rentus.utility;

import com.rentus.services.*;

//test.
public class ServiceFactory {
    public static ProductService getProductService() {
        return new ProductManagementService();
    }

    public static ClientService getclientService() {
        return new ClientManagementService();
    }

    public static UserService getUserService() {
        return new UserManagementService();
    }

    public static ShopManagementService getshopService() {
        return new ShopManagementService();
    }

    public static AdminManagementService getadminService() {
        return new AdminManagementService();
    }

    public static OrderManagementService getorderservice() {
        return new OrderManagementService();
    }
}


