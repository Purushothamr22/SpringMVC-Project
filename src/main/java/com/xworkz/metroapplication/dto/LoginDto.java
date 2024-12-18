package com.xworkz.metroapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private Integer id;
    @NotNull(message = "first Name must not null")
    @NotBlank(message = "first Name must not be blank")
    @NotEmpty(message = "first Name must not be empty")
    private String firstName;

    private String loginTime;

    private String logoutTime;

    @NotBlank(message = "emailId must not be blank")
    private String emailId;

    @NotBlank(message = "Password must not be blank ,empty ")
    @Size(min = 1, max = 8, message = "password length should be between 1 - 8 characters")
    private String password;


}
