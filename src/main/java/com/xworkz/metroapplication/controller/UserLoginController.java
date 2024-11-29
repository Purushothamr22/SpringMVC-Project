package com.xworkz.metroapplication.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
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

    @GetMapping("/getUserOtpDetails")
    public String getUserOtpDetails(@RequestParam String emailId, Model model) {
        if (emailId == null) {
            model.addAttribute("UserLoginMsg", "Enter correct emailId");
            return "UserLogin";
        }
        UserRegistrationDto userOtpDetails = userService.getUserOtpDetails(emailId);

        if (userOtpDetails != null) {
            model.addAttribute("userDto",userOtpDetails);
            return "UserLogin";
        }
        return "UserLogin";
    }

    @PostMapping("/verifyUserOtp")
    public String verifyUserOtp( String otp, @RequestParam String emailId,Model model){
        if (otp == null||emailId==null) {
            model.addAttribute("UserLoginMsg","Enter valid details ");
            return "UserLogin";
        }
        log.info("email id is ==================  {}",emailId);
        log.info("otp is ====================  {}",otp);
        UserRegistrationDto userRegistrationDto = userService.onFindByUserEmail(emailId);
        log.info("dto is ==================== {}",userRegistrationDto);
        boolean isPresent = userService.verifyUserOtp(emailId, otp);
        if (isPresent){
            log.info("userService.verifyUserOtp  is persent true");
            List<StationDetailsDto> stationDetailsDtoList = userInteractionService.onFindStationDetails();
            log.info("list === {}",stationDetailsDtoList);
            model.addAttribute("verifyUserOtpDto",userRegistrationDto);
            model.addAttribute("stationDetailsDtoList",stationDetailsDtoList);
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
