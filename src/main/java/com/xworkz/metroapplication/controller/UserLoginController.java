package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/")
public class UserLoginController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public String saveLoginInfo(@RequestParam String emailId,@RequestParam String password , Model model){
        if (emailId!=null&& password!=null){

        }

        return "";
    }
}
