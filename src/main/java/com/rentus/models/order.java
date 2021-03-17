package com.rentus.models;

public class order {
    private int id;
    private  int Shop_id;
    private int tool_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShop_id() {
        return Shop_id;
    }

    public void setShop_id(int shop_id) {
        Shop_id = shop_id;
    }

    public int getTool_id() {
        return tool_id;
    }

    public void setTool_id(int tool_id) {
        this.tool_id = tool_id;
    }
}
