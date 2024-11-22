package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.service.MetroService;
import com.xworkz.metroapplication.service.TrainTimeDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@Slf4j
public class TrainTimeDetailsController {
    @Autowired
    private TrainTimeDetailsService timeDetailsService;
    @Autowired
    private MetroService metroService;
    public TrainTimeDetailsController() {
        log.info("TrainTimeDetails Controller created ");
    }

    @PostMapping("addTrainTimeDetails")
    public String addTrainTimeDetails(@Valid TrainTimeDetailsDto trainTimeDetailsDto, String emailId, BindingResult bindingResult, Model model) {
        log.info("email Id give is ............................   "+emailId);
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        if (bindingResult.hasErrors()) {
            model.addAttribute("TimeDetailsMsg", "Please Enter Correct Details");
            model.addAttribute("details", registrationDto);
            return "AdminPage";
        }
        String onSaveTimeDetails = timeDetailsService.onSaveTimeDetails(trainTimeDetailsDto);
        if (onSaveTimeDetails.equals("Data Saved")) {
            model.addAttribute("TimeDetailsMsg","Data Saved Successfully");
            model.addAttribute("details", registrationDto);
            return "AdminPage";
        } else if (onSaveTimeDetails.equals("Data Error")) {
            model.addAttribute("TimeDetailsMsg","Error in Data ");
            model.addAttribute("details", registrationDto);
            return "AdminPage";
        } else if (onSaveTimeDetails.equals("Save Error")) {
            model.addAttribute("TimeDetailsMsg","Data Save UnSuccessful");
            model.addAttribute("details", registrationDto);
            return "AdminPage";
        }

        return "AdminPage";
    }

}
