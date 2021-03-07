package com.rentus.services;

import com.rentus.models.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToolsService {
    List<Tool> getTools();
    void orderTool(Tool tool);
}
