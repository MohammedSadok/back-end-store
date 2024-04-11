package com.master.backend.product;

import com.master.backend.catogory.Category;
import com.master.backend.color.Color;
import com.master.backend.image.Image;
import com.master.backend.size.Size;
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
