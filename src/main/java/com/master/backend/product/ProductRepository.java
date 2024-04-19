package com.master.backend.product;

import com.master.backend.catogory.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> getProductsByCategory(Category category);
}