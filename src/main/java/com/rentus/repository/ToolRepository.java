package com.rentus.repository;

import com.rentus.models.Tools;

import java.util.List;

public interface ToolRepository {

    void addTool(Tools tool);
      List<Tools> allTools();
      void delete(int id);
      void update(int id);
      void getById();
      void getByType();
      void Available();

  }
