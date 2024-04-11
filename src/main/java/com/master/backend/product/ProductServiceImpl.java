package com.master.backend.product;

import com.master.backend.catogory.Category;
import com.master.backend.catogory.CategoryRepository;
import com.master.backend.color.Color;
import com.master.backend.color.ColorRepository;
import com.master.backend.image.Image;
import com.master.backend.size.Size;
import com.master.backend.size.SizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ColorRepository colorRepository;
    private final SizeRepository sizeRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = new Product();

        // Set basic product properties
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setQuantity(productRequest.getQuantity());
        product.setFeatured(productRequest.isFeatured());

        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        product.setCategory(category);

        List<Color> colors = new ArrayList<>();
        for (Integer colorId : productRequest.getColors()) {
            Color color = colorRepository.findById(colorId)
                    .orElseThrow(() -> new IllegalArgumentException("Color with ID " + colorId + " not found"));
            colors.add(color);
        }
        product.setColors(colors);

        List<Size> sizes = new ArrayList<>();
        for (Integer sizeId : productRequest.getSizes()) {
            Size size = sizeRepository.findById(sizeId)
                    .orElseThrow(() -> new IllegalArgumentException("Size with ID " + sizeId + " not found"));
            sizes.add(size);
        }
        product.setSizes(sizes);

        List<Image> images = new ArrayList<>();
        for (String imageUrl : productRequest.getImageUrls()) {
            Image image = new Image();
            image.setImageUrl(imageUrl);
            image.setProduct(product);
            images.add(image);
        }
        product.setImages(images);


        return productRepository.save(product);
    }
}
