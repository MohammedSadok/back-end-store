package com.master.backend.api.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.master.backend.api.catogory.Category;
import com.master.backend.api.color.Color;
import com.master.backend.api.image.Image;
import com.master.backend.api.size.Size;
import com.master.backend.api.orderItem.OrderItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private float price;
    private String description;
    private int quantity;
    private boolean isFeatured;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image> images;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<OrderItem> orderItems;

    @ManyToMany
    @JoinTable(name = "product_color",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id"))
    private List<Color> colors;

    @ManyToMany
    @JoinTable(name = "product_size",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id"))
    private List<Size> sizes;
}
