package com.rentus.models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "allOrders", query = "FROM Order O INNER JOIN FETCH O.product"),
        @NamedQuery(name = "getParticularOrder", query = "FROM Order O INNER JOIN FETCH O.product  where O.client= :client")
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
//    @JoinColumn(name = "tool_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    public Client client;

    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Expose
    private String address;
    @Expose
    private String phone;

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

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                ", client=" + client +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", bookedDate=" + bookedDate +
                ", expiryDate=" + expiryDate +
                '}';
    }

    public void setClient(Client client) {
        this.client = client;
    }

    //    @





    //
//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
}