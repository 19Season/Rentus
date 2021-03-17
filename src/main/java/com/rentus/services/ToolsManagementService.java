package com.rentus.services;


/*//import com.rentus.models.Jacket;
import com.rentus.models.JacketType;
import com.rentus.models.Shoe;
import com.rentus.models.Tent;
import com.rentus.models.TentType;*/
import com.rentus.models.Tools;
import com.rentus.repository.ToolRepository;
import com.rentus.utility.RepoFactory;

import java.util.List;


public class ToolsManagementService implements ToolsService {
private ToolRepository toolRepo;
public ToolsManagementService(){
    this.toolRepo = RepoFactory.getToolRepo();

}


    @Override
    public List<Tools> getTools() {
        return toolRepo.allTools();
    }

    @Override
    public void orderTool(Tools tool) {

    }

    @Override
    public void addtool(Tools tool) {
        toolRepo.addTool(tool);
    }
  }
