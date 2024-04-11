package com.master.backend.size;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SizeRequest {
    @NotEmpty(message = "Size name is required !")
    @NotBlank(message = "Size name should not be empty !")
    private String name;

    @NotEmpty(message = "Size value is required !")
    @NotBlank(message = "Size value should not be empty !")
    private String value;
}
