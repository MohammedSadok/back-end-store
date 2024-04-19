package com.master.backend.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "userName is required !")
    @NotBlank(message = "userName is required !")
    private String userName;
    @Email(message = "Email is not valid !")
    @NotEmpty(message = "email is required !")
    @NotBlank(message = "email is required !")
    private String email;

    @NotEmpty(message = "password is required !")
    @NotBlank(message = "password is required !")
    @Size(min = 8,message = "password must contain 8 characters min")
    private String password;

}
