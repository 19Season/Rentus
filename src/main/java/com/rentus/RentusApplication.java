package com.rentus;

import com.rentus.controllers.*;
import com.rentus.utility.SessionFactory;

import java.util.logging.Logger;

import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class RentusApplication {
	private final static Logger LOGGER = Logger.getLogger(RentusApplication.class.getName());
	public static void main(String[] args) {
		try{
			port(1234);
			//staticFileLocation("dist/index.html");

			String projectDir = System.getProperty("user.dir");
			String staticDir = "/src/main/resources/public";
			staticFiles.externalLocation(projectDir + staticDir);

			SessionFactory.getInstance();
			ToolsController.addtool();
			ToolsController.updateTools();
			ToolsController.alltools();
			ToolsController.getById();
			ToolsController.getAllBookedTools();
			ToolsController.getByCategories();
			ClientController.Login();
			ClientController.Register();
			ShopController.register();
			ShopController.login();
			AdminController.register();
			AdminController.login();
			OrderController.allOrder();
			OrderController.cancelOrder();
			OrderController.getParticularOrder();
			OrderController.makeOrder();
			ImageControllers.uploadImage();
		}catch (Exception e ){
			e.printStackTrace();
			LOGGER.info(e.getMessage());

		}
		System.out.println("hello");
	}

}
