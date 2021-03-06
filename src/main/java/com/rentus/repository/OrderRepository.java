
package com.rentus.repository;

import com.rentus.models.Order;

import java.util.List;

public interface OrderRepository {
     boolean makeOrder(Order order);
     boolean cancelOrder(int id);
     List<Order> getallOrders();
     List<Order> getParticularOrder(int id);
    }

