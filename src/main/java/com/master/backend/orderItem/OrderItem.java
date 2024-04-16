package com.master.backend.orderItem;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.master.backend.color.Color;
import com.master.backend.order.Order;
import com.master.backend.product.Product;
import com.master.backend.size.Size;
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