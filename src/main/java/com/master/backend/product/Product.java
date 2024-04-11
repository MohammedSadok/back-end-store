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
    private boolean isFeatured;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Image> images;

    @OneToMany(mappedBy = "product")
    private List<Size> sizes;

    @OneToMany(mappedBy = "product")
    private List<Color> colors;
}
