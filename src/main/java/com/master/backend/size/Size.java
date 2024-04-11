package com.master.backend.size;// Size.java
import com.master.backend.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String value;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
