package com.rentus.controllers;

import com.google.gson.Gson;
import com.rentus.models.Tools;
import com.rentus.utility.ServiceFactory;

import static spark.Spark.post;

public class ToolsController {
   public static void addtool(){
       post("/api/addtool",(req, res)-> {
           Tools tool = new Gson().fromJson(req.body(), Tools.class);
           System.out.println(tool);
           ServiceFactory.gettoolService().addtool(tool);
           return true;
       });
    }

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






