package com.example.cloneproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    @NotBlank(message = " Email can't be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password can't be blank")
    @Size(min =8 , message = " Password must be at least 8 characters long ")
    private String password;


}

