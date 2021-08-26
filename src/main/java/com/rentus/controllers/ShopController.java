package com.rentus.controllers;

import com.google.gson.Gson;
import com.rentus.models.Shop;
import com.rentus.utility.GsonFactory;
import com.rentus.utility.ServiceFactory;

import static spark.Spark.get;
import static spark.Spark.post;

public class ShopController {
    public static void register() {
        post("/api/shop/signUp", (req, res) -> {
            try {
                Shop shop = new Gson().fromJson(req.body(), Shop.class);
                ServiceFactory.getshopService().register(shop);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        });
    }

    public static void login() {
        post("/api/shop/signIn", (req, res) -> {
            try {
                Shop shop = new Gson().fromJson(req.body(), Shop.class);
                return GsonFactory.gson().toJson(ServiceFactory.getshopService().login(shop));

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        });
    }

    public static void allShops() {
        get("/api/shops", (req, res) -> {
            try {
                return GsonFactory.gson().toJson(ServiceFactory.getshopService().getShops());
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to fetch shops";
            }
        });

    }
//    public static void approveShop() {
//        get("/api/shop/approve/:id", (req, res) -> {
//            int id = Integer.parseInt(req.params("id"));
//            System.out.println(id);
//            return ServiceFactory.getshopService().approveShop(id);
//        });
//    }
}



