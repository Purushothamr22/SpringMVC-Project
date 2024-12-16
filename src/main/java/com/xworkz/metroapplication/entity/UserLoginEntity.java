package com.xworkz.metroapplication.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_login_Details")
@NamedQuery(name = "findByUserId",query = "SELECT U FROM UserRegistrationEntity U WHERE U.userRegistrationId=:userRegistrationId")
public class UserLoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userLoginId;
    private String firstName;
    private String loginTime;
    private String logoutTime;
    private String emailId;
}
