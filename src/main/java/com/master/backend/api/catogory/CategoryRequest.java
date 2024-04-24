package com.master.backend.api.catogory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CategoryRequest {
    @NotEmpty(message = "Category name is required !")
    @NotBlank(message = "Category name is required !")
    private String name;
}
