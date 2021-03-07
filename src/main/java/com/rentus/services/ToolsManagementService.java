package com.rentus.services;


import com.rentus.models.Jacket;
import com.rentus.models.JacketType;
import com.rentus.models.Shoe;
import com.rentus.models.Tent;
import com.rentus.models.TentType;
import com.rentus.models.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToolsManagementService implements ToolsService {

    String myTitle = "";

    @Override
    public List<Tool> getTools() {
        ArrayList<Tool> tools = new ArrayList<>();

        Tool boot1 = new Shoe();
        boot1.setId(1);
        boot1.setName("Dingo");


        Tool boot2 = new Shoe();
        boot2.setId(2);
        boot2.setName("Dr. Martin");

        tools.add(boot1);
        tools.add(boot2);

        Jacket nfJacket = new Jacket();
        nfJacket.setName("Northface Jacket");
        nfJacket.setId(3);
        nfJacket.setType(JacketType.LEATHER);
        tools.add(nfJacket);

        Tent ten1 = new Tent();
        ten1.setId(3);
        ten1.setName("tent");
        ten1.setType(TentType.CURVED);
        tools.add(ten1);

        return tools;

    }

    @Override
    public void orderTool(Tool tool) {

        tool.setDescription("testing");
        //db.save(tool);

        System.out.println(tool);
    }


}
