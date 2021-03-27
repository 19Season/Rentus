package com.rentus.controllers;

import com.google.gson.Gson;
import com.rentus.models.Client;
import com.rentus.utility.ServiceFactory;

import static spark.Spark.post;

public class ClientController {

    public static void Register(){
        post("/api/SignUp",(req,res)-> {
            Client client = new Gson().fromJson(req.body(), Client.class);
            ServiceFactory.getclientService().Register(client);
            return true;

        });
    }

    public static void Login(){
        post("/api/SignIn",(req,res) -> {
            Client client = new Gson().fromJson(req.body(), Client.class);
            ServiceFactory.getclientService().Login(client);
            return true;
        });
    }

}
