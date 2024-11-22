package com.xworkz.metroapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserRegistrationDto {

    private Integer id;
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
    private String birthdayDate;

    private String userImage;
    private String imageType;

}
