package com.master.backend.api.orderItem;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.master.backend.api.color.Color;
import com.master.backend.api.product.Product;
import com.master.backend.api.size.Size;
import com.master.backend.api.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @ManyToOne
    private Size size;
    @ManyToOne
    private Color color;

    @ManyToOne
    @JsonBackReference
    private Order order;

    @ManyToOne

    private Product product;
}