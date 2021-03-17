package com.rentus.controllers;

import antlr.Tool;
import com.rentus.models.Tools;
import com.rentus.utility.ServiceFactory;

import javax.persistence.criteria.Order;

/*public class OrderController {
    public boolean orderTools(int Shop_id, int tool_id){
        Tool tool =  ServiceFactory.getToolservice().getTool(tool_id); //db call
        if(tool.isBooked()) return false;
        tool.setBooked(true);
        ServiceFactory.getToolservice().update(tool);
        Order order = New Order();
        order.settool_id(tool_id);
        order.

    }
}*/
