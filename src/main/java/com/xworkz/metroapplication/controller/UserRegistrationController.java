package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.UserRegistrationDto;
import com.xworkz.metroapplication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/")
public class UserRegistrationController {

    @Autowired
    private UserService userService;
    @GetMapping("/getUserRegistrationInfo")
    public String getUserRegistrationInfo() {
        return "UserRegistrationInfo";
    }
    @PostMapping("/saveUserInfo")
    public String saveUserInfo(@Valid UserRegistrationDto userRegistrationDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userInfoMsg", "Error in the given details ");
            return "UserRegistrationInfo";
        }
        String onSaveUserInfo = userService.onSaveUserInfo(userRegistrationDto);
        if (onSaveUserInfo.equals("Data saved")) {
            model.addAttribute("indexMsg", "Data Successfully Saved ");
            return "index";
        }
        return "UserRegistrationInfo";
    }
    @GetMapping("/isUserEmailExists")
    public ResponseEntity<String> isUserEmailExists(@RequestParam String emailId) {
        if (emailId != null) {
            UserRegistrationDto userRegistrationDto = userService.onFindByUserEmail(emailId);
            if (userRegistrationDto != null) {
                return ResponseEntity.ok("Email Exists ");
            }
        }
        return ResponseEntity.ok("Email Does not exists");
    }
    @GetMapping("/isMobileNoExists")
    public ResponseEntity<String> isMobileNoExists(@RequestParam Long mobileNumber) {
        if (mobileNumber != null) {
            UserRegistrationDto userRegistrationDto = userService.onFindByMobileNo(mobileNumber);
            if (userRegistrationDto != null) {
                return ResponseEntity.ok("Mobile Number Exists ");
            }
        }
        return ResponseEntity.ok("Mobile Number Accepted");
    }


}
