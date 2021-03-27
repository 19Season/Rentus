package com.rentus.models;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "getBooked", query = "FROM Tool t where t.isBooked = :booked"),
        @NamedQuery(name = "getCategory", query = " FROM Tool t where t.type= :type")
})


@Entity
public class Tool {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int size;
    private String description;
    private  int price;
    private String type;
    private boolean isBooked;
    @OneToOne
    private Shop shop;

    public boolean isBooked()
    {
        return isBooked;
    }

    public void setBooked(boolean booked)
    {
        isBooked = booked;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
