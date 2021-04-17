package com.rentus.models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "allOrders", query = "FROM Order O INNER JOIN FETCH O.tool"),
        @NamedQuery(name = "getParticularOrder", query = "FROM Order O INNER JOIN FETCH O.tool  where O.userId= :userId")
})

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    @Expose
    private int id;

    @Expose
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tool_id")
    private Product product;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "client_id")
//    private Client client;

    @Expose
    private int userId;

    @Expose
    private Long bookedDate;
    @Expose
    private Long expiryDate;

    public Long getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(Long bookedDate) {
        this.bookedDate = bookedDate;
    }

    public Long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    //
//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
}