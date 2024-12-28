package com.xworkz.metroapplication.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "login_details")
@NamedQuery(name = "adminUpdateLogout",query = "UPDATE  LoginEntity r SET r.logoutTime = :logoutTime WHERE r.emailId = :emailId")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String loginTime;
    private String logoutTime;
    private String password;
    private String emailId;

}
