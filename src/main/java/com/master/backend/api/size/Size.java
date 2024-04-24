package com.master.backend.api.size;// Size.java
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.master.backend.api.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String value;

    @ManyToMany(mappedBy = "sizes")
    @JsonBackReference
    private List<Product> products;
}
