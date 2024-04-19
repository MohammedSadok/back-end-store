package com.master.backend.product;

import com.master.backend.catogory.Category;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product createProduct(ProductRequest product);
    List<Product> getProductsByCategory(int categoryId);
}
