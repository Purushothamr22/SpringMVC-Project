package com.xworkz.metroapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_registration_details")

public class UserRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String emailId;
    private Long mobileNumber;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String otp;
    private Integer noOfAttempts;
    private boolean isAccountBlocked;
    private String birthdayDate;
    private String userImage;
    private String imageType;

}
