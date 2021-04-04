package com.rentus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@NamedQuery(name = "findShopUsername", query = "FROM Shop s where s.username = :username")
@Entity
@Table(name = "shops")
public class Shop {
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shop")
    private List<Tool> tools;

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

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }





 /* @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                ", Username='" + Username + '\'' +
                '}';
    }*/
}
