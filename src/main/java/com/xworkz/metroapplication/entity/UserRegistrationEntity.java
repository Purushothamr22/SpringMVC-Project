package com.xworkz.metroapplication.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_registration_details")
@NamedQuery(name ="findByUserEmail", query = "SELECT r FROM UserRegistrationEntity r WHERE r.emailId = :emailId")
@NamedQuery(name = "passwordWrongAttemptByUserEmail",query = "UPDATE  UserRegistrationEntity r SET r.isAccountBlocked = :isAccountBlocked,r.noOfAttempts = :noOfAttempts WHERE r.emailId = :emailId")
@NamedQuery(name = "findUserOtpDetailsByEmail",query = "SELECT u FROM UserRegistrationEntity u WHERE u.emailId =:emailId ")
@NamedQuery(name = "updateUserOtp",query = "UPDATE UserRegistrationEntity u SET u.otp =:otp WHERE u.emailId =: emailId ")
@NamedQuery(name = "findByUserMobileNo" ,query = "SELECT U FROM UserRegistrationEntity U WHERE U.mobileNumber=:mobileNumber")
public class UserRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userRegistrationId;
    private String emailId;
    private Long mobileNumber;
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
