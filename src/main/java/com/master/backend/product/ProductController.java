package com.master.backend.product;

import com.master.backend.catogory.CategoryService;
import com.master.backend.color.ColorService;
import com.master.backend.image.ImageRepository;
import com.master.backend.size.SizeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final SizeService sizeService;
    private final ColorService colorService;
    private final ImageRepository imageRepository;


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable int id) {
        List<Product> products = productService.getProductsByCategory(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        Product createdProduct = productService.createProduct(productRequest);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
}
