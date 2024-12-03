package com.xworkz.metroapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor


public class UserLoginDto {
    private Integer userLoginId;
    @NotNull(message = "first Name must not null")
    @NotBlank(message = "first Name must not be blank")
    @NotEmpty(message = "first Name must not be empty")
    private String firstName;
    private String loginTime;
    private String logoutTime;
    @NotBlank(message = "emailId must not be blank")
    private String emailId;
}
