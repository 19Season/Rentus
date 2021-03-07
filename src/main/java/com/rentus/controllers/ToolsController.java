package com.rentus.controllers;

import com.rentus.models.Tool;
import com.rentus.services.ToolsManagementService;
import com.rentus.services.ToolsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ToolsController {

    private ToolsService toolsService;

    public ToolsController() {
        toolsService = new ToolsManagementService();
    }

    @GetMapping("tools")
    public List<Tool> getAllTools() {
        var tools = toolsService.getTools();
        return tools;
    }

    @PostMapping("tools")
    public void addTool(Tool tool) {
        toolsService.orderTool(tool);
    }

}


