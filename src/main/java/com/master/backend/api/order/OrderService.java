package com.master.backend.api.order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();

    Optional<Order> getOrderById(int id);

    Order createOrder(Order order);

    Order updateOrder(Order order);

    void deleteOrder(int id);
}
