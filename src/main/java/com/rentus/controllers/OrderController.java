
package com.rentus.controllers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rentus.models.Order;
import com.rentus.utility.GsonFactory;
import com.rentus.utility.ServiceFactory;

import static spark.Spark.get;
import static spark.Spark.post;

public class OrderController {
    public static void makeOrder() {
        post("/api/orders/order", (req, res) -> {
            try {
                Order order = new Gson().fromJson(req.body(), Order.class);
                ServiceFactory.getorderservice().makeOrder(order);
                return true;
            }
            catch(Exception e) {
                e.printStackTrace();
                return "failed to place order";
            }

        });
    }

    public static void cancelOrder() {
        get("/api/orders/order/:id/cancel", (req, res) -> {
            try {
                int id = Integer.parseInt(req.params("id"));
                return GsonFactory.gson().toJson(ServiceFactory.getorderservice().cancelOrder(id));
            }
            catch(Exception e) {
                e.printStackTrace();
                return "failed to cancel order";
            }

        });
    }


    public static void allOrders() {
        get("/api/orders", (req, res) -> {
            try {
                return GsonFactory. gson().toJson(ServiceFactory.getorderservice().allorder());
            }
            catch(Exception e) {
                e.printStackTrace();
                return "failed to fetch orders";
            }
        });
    }

    public static void getParticularOrder() {
        get("/api/orders/order/:id", (req, res) -> {
            try {
                int id = Integer.parseInt(req.params("id"));
                return GsonFactory.gson().toJson(ServiceFactory.getorderservice().getParticularOrder(id));
            }
            catch(Exception e) {
                e.printStackTrace();
                return "failed to fetch order by client";
            }
        });
    }
}

