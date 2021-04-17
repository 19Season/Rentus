package com.rentus.models;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name= "users")
@NamedQueries({
        @NamedQuery(name = "getByUserName", query = "FROM User u where t.username = :username"),
})


public class User {

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
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Order> orders;

    @Expose
    private boolean authenticated;

    @Expose
    private String role;


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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}