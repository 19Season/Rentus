package com.rentus.models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "getBooked", query = "FROM Product t where t.isBooked =:booked"),
        @NamedQuery(name = "getCategory", query = "FROM Product t where t.type=:type"),
        @NamedQuery(
                name="findByClient",
                query="from Product where client=:client"
        ),
        @NamedQuery(
                name="findByShopId",
                query="from Product p  where p.shop= :shop"
        ),
})


@Entity
@Table(name="tools")
public class Product {

    @Id
    @GeneratedValue
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private int size;
    @Expose
    private String description;
    @Expose
    private  int price;
    @Expose
    private String type;
    @Expose
    private boolean isBooked;

    @Expose
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id")
    private Client client;

    @Expose
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Order order;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBooked=" + isBooked +
//                ", shop=" + shop +
                ", order=" + order +
                '}';
    }
}