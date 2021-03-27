package com.rentus.repository;

import com.rentus.models.Tool;

import java.util.List;

public interface ToolRepository {

      void addTool(Tool tool);
      List<Tool> allTools();
      List<Tool> getAllBookedTool();
      void delete(Tool tool);
      boolean update(int id, Tool tools);
      Tool getById(int id);
      List<Tool> getByCategories(String type);
      void Available();
      //boolean cancelBook(int id);

  }
