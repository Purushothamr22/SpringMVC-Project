package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.service.MetroService;
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

    MetroService metroService;

    public RegistrationController() {
        System.out.println("Registration controller created");
    }

    @PostMapping("/onSaveRegistration")
    public String onSaveRegistration(@Valid RegistrationDto registrationDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("registrationMsg", "Please enter details correctly");
            return "Registration";
        }
        boolean isSaved = metroService.onSaveRegistrationDetails(registrationDto);
        if(isSaved){
            model.addAttribute("indexMsg", "registration successful");
            return "index";
        }
        return  "Registration";
    }

    @GetMapping("/registration")
    public String onSaveRegistration() {
        return "registration";
    }

    @GetMapping("/metroFetch")
    public String onFetchAll(Model model) {
        List<RegistrationDto> registrationDto = metroService.onFetchAll();
        if (!registrationDto.isEmpty()) {
            model.addAttribute("users", registrationDto);
            model.addAttribute("FetchSuccess", "Fetched details Successfully");
            System.out.println(registrationDto);
            log.info("on fetch method");
            return "MetroFetch";
        }
        model.addAttribute("FetchError", "details not found");
        return "MetroFetch";
    }

    @PostMapping("/onFindByName")
    public String onFindByUName(@RequestParam String firstName, Model model) {
        log.info("this is on find by user name controller ");
        if (firstName != null) {
            RegistrationDto registrationDto = metroService.onFindByName(firstName);
            List<RegistrationDto> registrationDtos =new ArrayList<>();
            registrationDtos.add(registrationDto);
            log.info("this is on find by user name after calling  metroService.onFindByName(firstName) ");
            model.addAttribute("users",registrationDtos);
            model.addAttribute("message", "Details found Successfully");
            return "MetroFetch";
        }
        model.addAttribute("message", "details not found");
        return "MetroFetch";
    }
    @PostMapping("/onFindByEmail")
    public String onFindByEmail(@RequestParam String firstName, Model model) {
        if (firstName != null) {
            RegistrationDto registrationDto = metroService.onFindByName(firstName);
            model.addAttribute("metroDto", registrationDto);
            return "MetroFetch";
        }
        model.addAttribute("FindBYNameError", "details not found");
        return "MetroFetch";
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
