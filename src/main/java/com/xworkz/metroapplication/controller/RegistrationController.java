package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.service.MetroService;
import com.xworkz.metroapplication.util.EmailClass;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class RegistrationController {
    @Autowired
    private MetroService metroService;
    @Autowired
    private EmailClass emailClass;

    public RegistrationController() {
        System.out.println("Registration controller created");
    }
    @GetMapping("/getRegistration")
    public String getRegistration() {
        return "Registration";
    }
    @PostMapping("/onSaveRegistration")
    public String onSaveRegistration(@Valid RegistrationDto registrationDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("registrationMsg", "Please enter details correctly");
            return "Registration";
        }
        boolean isSaved = metroService.onSaveRegistrationDetails(registrationDto);
        if(isSaved){
            String registrationEmail = emailClass.sendRegistrationEmail(registrationDto.getEmailId(), registrationDto.getFirstName());
            log.info("email result is ---------------------- {}",registrationEmail);
            model.addAttribute("registrationMsg", "registration successful");
            return "Registration";
        }
        return  "Registration";
    }
    @GetMapping("/isEmailExists")
    public ResponseEntity<String> isEmailExists(@RequestParam String emailId) {
        if (emailId != null) {
            RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
            if (registrationDto != null) {
                return ResponseEntity.ok("Email Exists");
            }
        }
        return ResponseEntity.ok("Email Accepted");
    }

    @GetMapping("/isMobileNumberExists")
    public ResponseEntity<String> isMobileNumberExists(@RequestParam Long mobileNumber) {
        log.info("mobile number in controller is ======================    " + mobileNumber);
        RegistrationDto registrationDto = metroService.onFindByMobileNumber(mobileNumber);
        if (registrationDto != null) {
            return ResponseEntity.ok("Mobile Number Exists");
        }
        return ResponseEntity.ok("Mobile Number Accepted");
    }

}
