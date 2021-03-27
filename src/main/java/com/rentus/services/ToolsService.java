package com.rentus.services;

import com.rentus.models.Tool;

import java.util.List;


public interface ToolsService {
    List<Tool> getTools();
    List<Tool> getBookedTools();
    boolean update(int id, Tool t);
    //void orderTool(Tool tool);
    void addtool( Tool tool);
    Tool findById(int id);
   List<Tool> findByCategories(String type);

    }
