package com.rentus.controllers;

import com.google.gson.Gson;
import com.rentus.models.Tool;
import com.rentus.utility.ServiceFactory;

import static spark.Spark.*;

public class ToolsController {

    public static void addtool() {
        post("/api/addtool", (req, res) -> {
            Tool tool = new Gson().fromJson(req.body(), Tool.class);
            System.out.println(tool);
            ServiceFactory.gettoolService().addtool(tool);
            return true;
        });
    }

    public static void updateTools() {
        put("/api/tool/edit/:id", (req, res) -> {
            Tool tool = new Gson().fromJson(req.body(), Tool.class);
            int id = Integer.parseInt(req.params("id"));
            return ServiceFactory.gettoolService().update(id, tool);
        });

    }

    public static void alltools() {
        get("/api/tool/alltools", (req, res) -> {
            return new Gson().toJson(ServiceFactory.gettoolService().getTools());
        });
    }

    public static void getAllBookedTools() {
        get("/api/tool/bookedtool", (req, res) -> {
            return new Gson().toJson(ServiceFactory.gettoolService().getBookedTools());
        });
    }

    public static void getById() {
        get("/api/getbyid/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            return new Gson().toJson(ServiceFactory.gettoolService().findById(id));
        });
    }

    public static void getByCategories() {
        get("/api/getByType/:type", (req, res) -> {
            String type = req.params("type");
            return new Gson().toJson(ServiceFactory.gettoolService().findByCategories(type));
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







