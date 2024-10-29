package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.PriceDetailsDto;
import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.service.MetroService;
import com.xworkz.metroapplication.service.PriceDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/")
public class PriceDetailsController {
    @Autowired
    PriceDetailsService priceDetailsService;
    @Autowired
    MetroService metroService;
    public PriceDetailsController() {
        log.info("PriceDetails Controller created");
    }

@PostMapping("savePriceDetails")
    public  String savePriceDetails(@Valid PriceDetailsDto priceDetailsDto, @RequestParam String emailId, BindingResult bindingResult, Model model){
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);

        if (bindingResult.hasErrors()){
            model.addAttribute("PriceMsg","Enter correct data ");
            model.addAttribute("details",registrationDto);
            return "UserPage";
        }
        String onSavePriceDetails = priceDetailsService.onSavePriceDetails(priceDetailsDto);
        if (onSavePriceDetails.equals("Data Saved")) {
            model.addAttribute("PriceMsg","Data Saved successfully ");
            model.addAttribute("details",registrationDto);
            return "UserPage";
        } else if (onSavePriceDetails.equals("Save Error")) {
            model.addAttribute("PriceMsg","Data already Present ");
            model.addAttribute("details",registrationDto);
            return "UserPage";
        }
        return "UserPage";

    }
}
