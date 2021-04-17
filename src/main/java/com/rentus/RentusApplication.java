package com.rentus;

import com.rentus.controllers.*;
import com.rentus.utility.SessionFactory;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;

import java.util.HashMap;
import java.util.logging.Logger;

import static spark.Spark.after;
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

			RentusApplication.apply();
			SessionFactory.getInstance();
			ProductsController.addProduct();
			ProductsController.updateTools();
			ProductsController.allProducts();
			ProductsController.getById();
			ProductsController.getAllBookedTools();
			ProductsController.getByCategories();
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

	private static final HashMap<String, String> corsHeaders = new HashMap<String, String>();

	static {
		corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		corsHeaders.put("Access-Control-Allow-Origin", "*");
		corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
		corsHeaders.put("Access-Control-Allow-Credentials", "true");
	}

	public final static void apply() {
		Filter filter = new Filter() {
			@Override
			public void handle(Request request, Response response) throws Exception {
				corsHeaders.forEach((key, value) -> {
					response.header(key, value);
				});
			}
		};
		Spark.after(filter);
	}

}
