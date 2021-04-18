package com.rentus.controllers;

import com.google.gson.Gson;
import com.rentus.models.Client;
import com.rentus.models.User;
import com.rentus.utility.ServiceFactory;

import static spark.Spark.post;

public class UsersController {

    public static void Register() {
        post("/api/users/register", (req, res) -> {
            try {
                User user = new Gson().fromJson(req.body(), User.class);
                ServiceFactory.getUserService().register(user);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to signup";
            }

        });
    }

    public static void login() {
        post("/api/users/login", (req, res) -> {
            try {
                User user = new Gson().fromJson(req.body(), User.class);
                String userName = req.params("username");
                String password = req.params("password");
                return ServiceFactory.getUserService().getUser(userName, password);
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to signin";
            }

        });
    }

}
