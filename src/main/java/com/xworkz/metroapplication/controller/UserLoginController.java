package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.UserRegistrationDto;
import com.xworkz.metroapplication.service.UserInteractionService;
import com.xworkz.metroapplication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/")
public class UserLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInteractionService userInteractionService;
    @GetMapping("/getUserLogin")
    public String getUserLogin(){
        return "UserLogin";
    }
    @GetMapping("/getLogout")
    public String getLogout(String emailId,Model model){
        log.info("log out controller ");
        UserRegistrationDto userRegistrationDto = userService.onFindByUserEmail(emailId);
        String updateLogout = userService.updateLogout(emailId);
        return "UserLogin";
    }
    @GetMapping("/getUserOtpDetails")
    public String getUserOtpDetails(@RequestParam String emailId, Model model) {
        UserRegistrationDto userOtpDetails = userService.getUserOtpDetails(emailId);
        if (userOtpDetails != null) {
            model.addAttribute("OtpMsg","Otp Sent Successfully");
            model.addAttribute("userDto",userOtpDetails);
            return "UserLogin";
        }
        model.addAttribute("OtpMsg","Otp Sending error");
        return "UserLogin";
    }
    @PostMapping("/verifyUserOtp")
    public String verifyUserOtp( String otp, @RequestParam String emailId,Model model){
        if (otp == null||emailId==null) {
            model.addAttribute("UserLoginMsg","Enter valid details ");
            return "UserLogin";
        }
        UserRegistrationDto userRegistrationDto = userService.onFindByUserEmail(emailId);
        boolean isPresent = userService.verifyUserOtp(emailId, otp);
        if (isPresent){
            model.addAttribute("verifyUserOtpDto",userRegistrationDto);
            return "UserPage";
        }
        return "UserLogin";
    }
    @GetMapping("/getUserPageByEmail")
    public String getUserPageByEmail(@RequestParam String emailId, Model model){
        if (emailId==null){
            model.addAttribute("getUserPageMsg","Data error");
        }
        UserRegistrationDto userRegistrationDto = userService.onFindByUserEmail(emailId);
        if (userRegistrationDto==null){
            model.addAttribute("getUserPageMsg","Data not found");
        }
        model.addAttribute("userDto",userRegistrationDto);
        return "UserPage";
    }


}
