package com.master.backend.catogory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.master.backend.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Product> products;
}