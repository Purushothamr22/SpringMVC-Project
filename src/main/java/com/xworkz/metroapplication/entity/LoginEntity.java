package com.xworkz.metroapplication.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "login_details")

public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String loginTime;
    private String logoutTime;
    private String password;
    private String emailId;

}
