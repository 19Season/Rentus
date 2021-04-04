package com.rentus.models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "getParticularOrder", query = "FROM Order O INNER JOIN FETCH O.tool  where O.client.id = :client")
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
    private Tool tool;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

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

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}