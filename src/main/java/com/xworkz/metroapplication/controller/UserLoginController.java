package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.UserRegistrationDto;
import com.xworkz.metroapplication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/")
public class UserLoginController {
    @Autowired
    UserService userService;

    @PostMapping("/saveLoginInfo")
    public String saveLoginInfo(@RequestParam String emailId, @RequestParam String password, Model model) {
        UserRegistrationDto userRegistrationDto = userService.onFindByUserEmail(emailId);
        log.info("login dto email is ===========" + emailId);

        log.info("ON LOGIN SAVE DETAILS BY EMAIL ");
        if (userRegistrationDto == null) {
            model.addAttribute("userLoginMsg", "Enter correct email id");
            return "LoginByEmail";
        }
        if (userRegistrationDto.isAccountBlocked()) {
            model.addAttribute("userLoginMsg", "User Account is blocked Please reset your password  ");
            model.addAttribute("details", userRegistrationDto);

            return "LoginByEmail";
        } else {
            String message = userService.onSaveLoginInfo(emailId, password);
            if (message.equals("Invalid Login")) {
                model.addAttribute("userLoginMsg", "Email or  password is incorrect");
                model.addAttribute("details", userRegistrationDto);
                return "LoginByEmail";

            } else if (message.equals("Login Successful")) {
                model.addAttribute("userLoginMsg", "Login Successful");
                model.addAttribute("details", userRegistrationDto);
                return "UserPage";
            }
        }
        return "LoginByEmail";
    }

    @GetMapping("/getUserOtpDetails")
    public String getUserOtpDetails(@RequestParam String emailId, Model model) {
        if (emailId == null) {
            model.addAttribute("UserOtpMsg", "Enter correct otp");
            return "UserOtpValidation";
        }
        UserRegistrationDto userOtpDetails = userService.getUserOtpDetails(emailId);
        if (userOtpDetails != null) {
            userService.updateUserOtp(emailId);
        }
        return "";
    }


}
