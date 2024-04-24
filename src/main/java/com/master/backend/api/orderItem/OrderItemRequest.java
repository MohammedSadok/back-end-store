package com.master.backend.api.orderItem;

import com.master.backend.api.color.Color;
import com.master.backend.api.product.Product;
import com.master.backend.api.size.Size;
import com.master.backend.api.order.Order;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderItemRequest {
    @NotNull(message = "productId is required!")
    private int productId;

    @NotNull(message = "Quantity is required!")
    @Min(value = 1, message = "Quantity must be positive")
    private int quantity;

    @NotNull(message = "sizeId is required!")
    @NotBlank(message = "sizeId should not be empty!")
    private int sizeId;

    @NotNull(message = "colorId is required!")
    @NotBlank(message = "colorId should not be empty!")
    private int colorId;


    public static OrderItem mapToOrderItem(OrderItemRequest orderItemRequest, Order order) {
        Size size = new Size();
        Color color = new Color();
        OrderItem orderItem = new OrderItem();
        Product product = new Product();

        size.setId(orderItemRequest.getSizeId());
        color.setId(orderItemRequest.getColorId());
        product.setId(orderItemRequest.getProductId());

        orderItem.setQuantity(orderItemRequest.getQuantity());
        orderItem.setProduct(product);
        orderItem.setSize(size);
        orderItem.setColor(color);
        orderItem.setOrder(order);
        return orderItem;
    }
}
