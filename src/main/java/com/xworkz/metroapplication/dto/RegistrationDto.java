package com.xworkz.metroapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private Integer id;

    @NotBlank(message = "User Name must not be blank")
    private String userName;

    @NotBlank(message = "Password must not be blank ,empty ")
    @Size(min = 8,max = 12 ,message = "password length should be between 1 - 8 characters")
    private String password;

    @NotBlank(message = "emailId must not be blank")
    @Email(message = "Email should be a valid email address")
    private String emailId;

    @NotBlank(message = "Name should not be blank ")
    private String firstName;

    @NotBlank(message = "Name should not be blank ")
    private String lastName;

    @NotBlank(message = "Name should not be blank ")
    private String gender;

    @Max(value = 9999999999L, message = "number should not be more than 10 digits")
    @Min(value = 1000000000L, message = "number should  be more than 1 digits")
    private Long mobileNumber;
    private String otp;
    private Integer noOfAttempts;
    private boolean isAccountBlocked;
    @NotBlank
    @NotNull
    private String birthdayDate;
    private String userImage;
   private String imageType;


}
