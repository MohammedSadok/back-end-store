package com.master.backend.api.order;

import com.master.backend.api.orderItem.OrderItem;
import com.master.backend.api.orderItem.OrderItemRequest;
import com.master.backend.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderRequest {
    @NotNull(message = "userId is required!")
    private int userId;

    @NotNull(message = "Order products is required!")
    private List<OrderItemRequest> orderItemRequests;

    @NotNull(message = "Order status is required!")
    @NotBlank(message = "Order status should not be empty!")
    private String status;


    public static Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        User user = new User();
        user.setId(orderRequest.getUserId());
        order.setUser(user);
        order.setStatus(orderRequest.getStatus());
        List<OrderItem> items = orderRequest
                .getOrderItemRequests()
                .stream()
                .map(orderItemRequest -> OrderItemRequest.mapToOrderItem(orderItemRequest,order))
                .collect(Collectors.toList());
        order.setOrderItems(items);
        return order;
    }


}