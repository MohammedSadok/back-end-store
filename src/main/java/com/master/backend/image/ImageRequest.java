package com.master.backend.image;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ImageRequest {
    @NotEmpty(message = "Image URL is required!")
    @NotBlank(message = "Image URL should not be empty!")
    private String imageUrl;
}
