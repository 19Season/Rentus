package com.rentus;
import com.rentus.controllers.*;
import com.rentus.utility.SessionFactory;

import java.util.logging.Logger;

import static spark.Spark.*;

public class RentusApplication {
	private final static Logger LOGGER = Logger.getLogger(RentusApplication.class.getName());
	public static void main(String[] args) {
		try{

			port(1234);
			//staticFileLocation("dist/index.html");




			String projectDir = System.getProperty("user.dir");
			String staticDir = "/src/main/resources/public";
			staticFiles.externalLocation(projectDir + staticDir);

			options("/*", (request, response) -> {

				String accessControlRequestHeaders = request
						.headers("Access-Control-Request-Headers");
				if (accessControlRequestHeaders
						!= null) {
					response.header("Access-Control-Allow-Headers",
							accessControlRequestHeaders); }

				String accessControlRequestMethod = request
						.headers("Access-Control-Request-Method"); if (accessControlRequestMethod !=
						null) { response.header("Access-Control-Allow-Methods",
						accessControlRequestMethod); }

				return "OK"; });

			before((request, response) -> response.header("Access-Control-Allow-Origin",
					"*"));


//			RentusApplication.apply();
			SessionFactory.getInstance();
			ProductsController.createOrUpdate();
			ProductsController.allProducts();
			ProductsController.getById();
			ProductsController.getAllBookedTools();
			ProductsController.getByCategories();
			ProductsController.ShopTools();
			ClientController.allClients();
			ClientController.Login();
			ClientController.Register();
			ShopController.register();
			ShopController.login();
			ShopController.allShops();
			AdminController.register();
			AdminController.login();
			OrderController.allOrders();
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

//	private static final HashMap<String, String> corsHeaders = new HashMap<String, String>();
//
//	static {
//		corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
//		corsHeaders.put("Access-Control-Allow-Origin", "*");
//		corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
//		corsHeaders.put("Access-Control-Allow-Credentials", "true");
//	}
//
//	public final static void apply() {
//		Filter filter = new Filter() {
//			@Override
//			public void handle(Request request, Response response) throws Exception {
//				corsHeaders.forEach((key, value) -> {
//					response.header(key, value);
//				});
//			}
//		};
//		Spark.after(filter);
//	}

}
