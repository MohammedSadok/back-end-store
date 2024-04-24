package com.master.backend.api.product;

import com.master.backend.api.catogory.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> getProductsByCategory(Category category);
}