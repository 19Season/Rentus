package com.rentus.controllers;

import com.google.gson.Gson;
import com.rentus.models.Tool;
import com.rentus.utility.GsonFactory;
import com.rentus.utility.ServiceFactory;

import javax.transaction.Transactional;

import static spark.Spark.*;

public class ToolsController {

    public static void addtool() {

        post("/api/addtool", (req, res) -> {
            try {
                Tool tool = new Gson().fromJson(req.body(), Tool.class);
                System.out.println(tool);
                ServiceFactory.gettoolService().addtool(tool);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        });

    }

    public static void delete() {
        post("/api/deleteTools", (req, res) -> {
            try {
                Tool tool = new Gson().fromJson(req.body(), Tool.class);
                ServiceFactory.gettoolService().delete(tool);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        });
    }


    public static void updateTools() {
        put("/api/tool/edit/:id", (req, res) -> {
            try {
                Tool tool = new Gson().fromJson(req.body(), Tool.class);
                int id = Integer.parseInt(req.params("id"));
                return ServiceFactory.gettoolService().update(id, tool);
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to update tools";
            }

        });

    }

    public static void alltools() {
        get("/api/tool/alltools", (req, res) -> {
            try {
                return GsonFactory.gson().toJson(ServiceFactory.gettoolService().getTools());
            } catch (Exception e) {
                e.printStackTrace();
                return "failed to fetch tools";
            }
        });
    }

    public static void getAllBookedTools() {
        get("/api/tool/bookedtool", (req, res) -> {
            try {
                return GsonFactory.gson().toJson(ServiceFactory.gettoolService().getBookedTools());
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
                return GsonFactory.gson().toJson(ServiceFactory.gettoolService().findById(id));
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
                return GsonFactory.gson().toJson(ServiceFactory.gettoolService().findByCategories(type));
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







