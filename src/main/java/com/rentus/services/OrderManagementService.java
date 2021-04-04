
package com.rentus.services;

import com.rentus.models.Order;
import com.rentus.repository.OrderRepository;
import com.rentus.utility.RepoFactory;

import java.util.Calendar;
import java.util.List;


public class OrderManagementService implements OrderService {
    private OrderRepository OrderRepo;

    public OrderManagementService() {
        this.OrderRepo = RepoFactory.getOrderRepo();

    }

    @Override
    public Boolean makeOrder(Order order) {
              /*order.setTools(tool);
        order.setShop(shop);
        order.setClient(client);*/
        order.setBookedDate(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 3);
        calendar.add(Calendar.MONTH, 1);

        order.setExpiryDate(calendar.getTimeInMillis());
        this.OrderRepo.makeOrder(order);

        return true;
    }



    @Override
    public boolean cancelOrder(int id) {
        return this.OrderRepo.cancelOrder(id);
    }

    @Override
    public List<Order> allorder() {
        return this.OrderRepo.getallOrders();
    }

    @Override
    public List<Order> getParticularOrder(int id) {
        return this.OrderRepo.getParticularOrder(id);
    }
}

