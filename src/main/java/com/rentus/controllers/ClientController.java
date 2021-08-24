package com.rentus.controllers;

import com.google.gson.Gson;
import com.rentus.models.Client;
import com.rentus.utility.GsonFactory;
import com.rentus.utility.ServiceFactory;

import static spark.Spark.get;
import static spark.Spark.post;

public class ClientController {

    public static void Register() {
        post("/api/client/signUp", (req, res) -> {
            try {
                Client client = new Gson().fromJson(req.body(), Client.class);
                ServiceFactory.getclientService().Register(client);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to signup";
            }

        });
    }

    public static void Login() {
        post("/api/client/signIn", (req, res) -> {
            try {
                Client client = new Gson().fromJson(req.body(), Client.class);
                return GsonFactory.gson().toJson(ServiceFactory.getclientService().Login(client));
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to signin";
            }

        });
    }
    public static void allClients() {
        get("/api/clients", (req, res) -> {
            try {
                return GsonFactory.gson().toJson(ServiceFactory.getclientService().getClients());
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to fetch clients";
            }
        });
    }


}
