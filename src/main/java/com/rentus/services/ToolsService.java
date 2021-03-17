package com.rentus.services;

import com.rentus.models.Tools;

import java.util.List;


public interface ToolsService {
    List<Tools> getTools();
    void orderTool(Tools tool);
    void addtool( Tools tool);

}
