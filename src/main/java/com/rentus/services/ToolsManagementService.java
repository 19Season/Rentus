package com.rentus.services;


/*//import com.rentus.models.Jacket;
import com.rentus.models.JacketType;
import com.rentus.models.Shoe;
import com.rentus.models.Tent;
import com.rentus.models.TentType;*/
import com.rentus.models.Tool;
import com.rentus.repository.ToolRepository;
import com.rentus.utility.RepoFactory;

import javax.transaction.Transactional;
import java.util.List;


public class ToolsManagementService implements ToolsService {
private ToolRepository toolRepo;
public ToolsManagementService(){
    this.toolRepo = RepoFactory.getToolRepo();

}
    @Transactional
    @Override
    public List<Tool> getTools() {
        return toolRepo.allTools();
    }

    @Override
    public List<Tool> getBookedTools() {
        return toolRepo.getAllBookedTool();
    }

    @Override
    public boolean update(int id, Tool t) {
        return  RepoFactory.getToolRepo().update(id,t);
    }

    /*@Override
    public void orderTool(Tool tool) {
        toolRepo.

    }*/

    @Override
    public void addtool(Tool tool) {
        toolRepo.addTool(tool);
    }

    @Override
    public Tool findById(int id) {
        return (Tool) toolRepo.getById(id);
    }

    @Override
    public List<Tool> findByCategories(String type) {
        return toolRepo.getByCategories(type);
    }

    @Override
    public void delete(Tool tool) {
        toolRepo.delete(tool);
    }

}





