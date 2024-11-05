package com.xworkz.metroapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_registration_details")
@NamedQuery(name ="findByUserEmail", query = "SELECT r FROM UserRegistrationEntity r WHERE r.emailId = :emailId")
@NamedQuery(name = "passwordWrongAttemptByUserEmail",query = "UPDATE  UserRegistrationEntity r SET r.isAccountBlocked = :isAccountBlocked,r.noOfAttempts = :noOfAttempts WHERE r.emailId = :emailId")
@NamedQuery(name = "findUserOtpDetailsByEmail",query = "SELECT u.otp FROM UserRegistrationEntity u WHERE u.emailId =:emailId ")
@NamedQuery(name = "updateUserOtp",query = "UPDATE UserRegistrationEntity u SET u.otp =:otp WHERE u.emailId =: emailId ")
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
