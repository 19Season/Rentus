package com.rentus;

import com.rentus.controllers.ClientController;
import com.rentus.controllers.ToolsController;
import com.rentus.utility.SessionFactory;

import static spark.Spark.*;

public class RentusApplication {
	public static void main(String[] args) {
		port(8085);
		//staticFileLocation("dist/index.html");
		SessionFactory.getInstance();
		ToolsController.addtool();
		ToolsController.updateTools();
		ToolsController.alltools();
		ToolsController.getById();
		ToolsController.getAllBookedTools();
		ClientController.Login();
		ClientController.Register();
	}
}

