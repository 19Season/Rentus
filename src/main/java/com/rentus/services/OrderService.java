
package com.rentus.services;

import com.rentus.models.Order;

import java.util.List;


public interface OrderService {
    Boolean makeOrder(Order order);
    boolean cancelOrder(int id);
    List<Order> allorder();
    List<Order> getParticularOrder(int id);

}

