package com.rentus.models;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Login", query = "FROM Client t where t.Username = :Username"),
        @NamedQuery(name = "Register", query = "FROM Client t where t.Username =:Username")
})

public class Client {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private String phone;
    private String Email;
    private String password;
    private String Username;
    @OneToMany
    private Tool tool;

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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                ", Username='" + Username + '\'' +
                '}';
    }
}
