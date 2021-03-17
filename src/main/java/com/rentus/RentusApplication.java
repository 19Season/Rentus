package com.rentus;

import com.rentus.controllers.ToolsController;

import static spark.Spark.port;

public class RentusApplication {
	public static void main(String[] args) {
		port(8082);
		ToolsController.addtool();
	}
}

