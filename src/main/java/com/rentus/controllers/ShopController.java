package com.rentus.controllers;

import com.google.gson.Gson;
import com.rentus.models.Shop;
import com.rentus.utility.GsonFactory;
import com.rentus.utility.ServiceFactory;

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
                ServiceFactory.getshopService().login(shop);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        });
    }

}



