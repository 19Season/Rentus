package com.rentus.utility;

import com.rentus.services.ToolsManagementService;
import com.rentus.services.ToolsService;

public class ServiceFactory {
            public static ToolsService gettoolService()
            {
                return new ToolsManagementService();
            }

            }


