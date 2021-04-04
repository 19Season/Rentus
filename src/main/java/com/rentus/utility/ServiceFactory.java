package com.rentus.utility;

import com.rentus.services.*;

public class ServiceFactory {
            public static ToolsService gettoolService()
            {
                return new ToolsManagementService();
            }

            public static ClientService getclientService()
            {
                return new ClientManagementService();
            }

    public static ShopManagementService getshopService()
    { return new ShopManagementService();}

    public static AdminManagementService getadminService() {
        return new AdminManagementService();
    }

    public static OrderManagementService getorderservice() {
                return new OrderManagementService();
    }
}


