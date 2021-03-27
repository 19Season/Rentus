package com.rentus.utility;

import com.rentus.services.ClientManagementService;
import com.rentus.services.ClientService;
import com.rentus.services.ToolsManagementService;
import com.rentus.services.ToolsService;

public class ServiceFactory {
            public static ToolsService gettoolService()
            {
                return new ToolsManagementService();
            }

            public static ClientService getclientService(){
                return new ClientManagementService();
            }
            }


