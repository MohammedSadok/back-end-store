package com.master.backend.api.product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product createProduct(ProductRequest product);
    List<Product> getProductsByCategory(int categoryId);
}
