package com.rentus.controllers;

import com.google.gson.Gson;
import com.rentus.models.Product;
import com.rentus.utility.GsonFactory;
import com.rentus.utility.ServiceFactory;

import static spark.Spark.*;

public class ProductsController {

    public static void createOrUpdate() {

        post("/api/products/product", (req, res) -> {
            try {
                var productService = ServiceFactory.getProductService();
                Product product = new Gson().fromJson(req.body(), Product.class);
                if (product.getId() > 0) {
                    productService.create(product);
                } else {
                    productService.update(product);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        });

    }

    public static void delete() {
        post("/api/products/delete", (req, res) -> {
            try {
                Product product = new Gson().fromJson(req.body(), Product.class);
                ServiceFactory.getProductService().delete(product);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        });
    }


    public static void allProducts() {
        get("/api/products", (req, res) -> {
            try {
                return GsonFactory.gson().toJson(ServiceFactory.getProductService().getProducts());
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to fetch tools";
            }
        });
    }

    public static void getAllBookedTools() {
        get("/api/products/booked", (req, res) -> {
            try {
                return GsonFactory.gson().toJson(ServiceFactory.getProductService().getBookedProducts());
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to fetch booked tools";
            }

        });
    }

    public static void getById() {
        get("/api/getbyid/:id", (req, res) -> {
            try {
                int id = Integer.parseInt(req.params("id"));
                return GsonFactory.gson().toJson(ServiceFactory.getProductService().findById(id));
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to fetch tool by id";
            }

        });
    }

    public static void getByCategories() {
        get("/api/getByType/:type", (req, res) -> {
            try {
                String type = req.params("type");
                return GsonFactory.gson().toJson(ServiceFactory.getProductService().findByCategories(type));
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to fetch tool by type";
            }

        });

    }


   /* private ToolsService toolsService;
    public ToolsController() {
        toolsService = new ToolsManagementService();
    }

    @GetMapping("tools")
    public List<Tools> getAllTools() {
        var tools = toolsService.getTools();
        return tools;
    }

    @PostMapping("tools")
    public void addTool(Tools tools) {
        toolsService.orderTool(tools);
    }

    @GetMapping("search")
    public void search(HttpRequest req){
        //req.get.parameter
    }*/

}






