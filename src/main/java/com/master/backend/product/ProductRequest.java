package com.master.backend.product;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class ProductRequest {
    @NotEmpty(message = "Product name is required!")
    @NotBlank(message = "Product name should not be empty!")
    private String name;

    @NotNull(message = "Price is required!")
    @DecimalMin(value = "0.0", message = "Price must be a positive number")
    private Float price;

    @Size(max = 255, message = "Description length must be less than or equal to 255 characters")
    private String description;

    @NotNull(message = "Quantity is required!")
    @PositiveOrZero(message = "Quantity must be a positive number or zero")
    private int quantity;

    @NotEmpty(message = "Product isFeatured is required!")
    @NotBlank(message = "Product isFeatured should not be empty!")
    private boolean isFeatured;

    @NotNull(message = "Category ID is required!")
    @Positive(message = "Category ID must be a positive number")
    private int categoryId;

    @NotEmpty(message = "Image URLs are required!")
    private List<@URL(message = "Invalid image URL") String> imageUrls;

    @NotEmpty(message = "Color names are required!")
    private List<Integer> colors;

    @NotEmpty(message = "Sizes are required!")
    private List<Integer> sizes;


}