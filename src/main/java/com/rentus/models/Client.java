package com.rentus.models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "clients")
@NamedQueries({
        @NamedQuery(name = "login", query = "FROM Client t where t.username = :username"),
//        @NamedQuery(
//                name = "findUserByUsername",
//                query = "from Client where username=:username"
//        ),
//        @NamedQuery(
//                name = "findUserByEmail",
//                query = "from Client where email=:email"
//        )
})


public class Client {

    @Id
    @GeneratedValue
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private String address;
    @Expose
    private String phone;
    @Expose
    private String email;
    @Expose
    private String password;
    @Expose
    private String username;

    @Expose
    @OneToMany
            (fetch = FetchType.EAGER, mappedBy = "client")
    public List<Order> orders;

    public int getId() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<com.rentus.models.Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


}