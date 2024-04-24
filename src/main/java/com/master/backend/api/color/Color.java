package com.master.backend.api.color;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.master.backend.api.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String hexValue;

    @ManyToMany(mappedBy = "colors")
    @JsonBackReference
    private List<Product> products;

}
