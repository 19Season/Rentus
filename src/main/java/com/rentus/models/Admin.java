package com.rentus.models;

import javax.persistence.*;
@Entity
@Table(name = "admins")

@NamedQueries({

        @NamedQuery(name = "adminLogin", query = "FROM Admin a where a.username = :username"),
})

public class Admin {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}