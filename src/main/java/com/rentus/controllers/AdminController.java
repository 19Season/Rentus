package com.rentus.controllers;

import com.google.gson.Gson;
import com.rentus.models.Admin;
import com.rentus.models.Client;
import com.rentus.utility.ServiceFactory;

import static spark.Spark.post;
public class AdminController {
    public static void register(){
        post("api/admin/signUp",(req,res) ->{
            try {
                Admin admin = new Gson().fromJson(req.body(), Admin.class);
                ServiceFactory.getadminService().register(admin);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to signup";
            }
        });
    }


    public static void login(){
        post("/api/admin/signIn",(req,res) -> {
            try {
                Admin admin = new Gson().fromJson(req.body(), Admin.class);
                ServiceFactory.getadminService().login(admin);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to signin";
            }
        });
    }

}
