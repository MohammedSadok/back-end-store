package com.master.backend.product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product createProduct(ProductRequest product);
}
