package com.xworkz.metroapplication.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "registration_details")
@NamedQuery(name = "fetchall", query = "select r from RegistrationEntity r")
@NamedQuery(name = "fetchbyname", query = "SELECT r FROM RegistrationEntity r WHERE r.firstName = :name ")
@NamedQuery(name = "fetchByEmail", query = "SELECT r FROM RegistrationEntity r WHERE r.emailId = :emailId")
@NamedQuery(name = "updateByEmail",query = "UPDATE  RegistrationEntity r SET r.otp = :otp WHERE r.emailId = :emailId")
@NamedQuery(name = "updatePassword",query = "UPDATE  RegistrationEntity r SET r.password = :password WHERE r.emailId = :emailId")
@NamedQuery(name ="passwordWrongAttemptByEmail",query = "UPDATE  RegistrationEntity r SET r.isAccountBlocked = :isAccountBlocked,r.noOfAttempts = :noOfAttempts WHERE r.emailId = :emailId")
@NamedQuery(name = "findByMNumber",query = "SELECT r FROM RegistrationEntity r WHERE r.mobileNumber= :mobileNumber ")

public class RegistrationEntity {

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
