package com.master.backend.api.color;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ColorRequest {
    @NotEmpty(message = "Color name is required!")
    @NotBlank(message = "Color name should not be empty!")
    private String name;

    @NotEmpty(message = "Hex value is required!")
    @NotBlank(message = "Hex value should not be empty!")
    private String hexValue;
}
