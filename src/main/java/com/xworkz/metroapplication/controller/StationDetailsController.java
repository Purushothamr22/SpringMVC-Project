package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.service.StationDetailsService;
import com.xworkz.metroapplication.service.MetroService;
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

public class StationDetailsController {
    public StationDetailsController() {
        log.info("AddTrainDetailsController controller created");
    }

    @Autowired
    StationDetailsService stationDetailsService;
    @Autowired
    MetroService metroService;

    @PostMapping("/addStationDetails")
    public String addStationDetails(@Valid StationDetailsDto addStationDetailsDto, String emailId, BindingResult bindingResult, Model model) {

        log.error(emailId + " ============== is the given email id ");
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        String saveTrainDetails = stationDetailsService.saveTrainDetails(addStationDetailsDto);

        if (bindingResult.hasErrors()) {
            model.addAttribute("trainMsg", "Error in saving");
            model.addAttribute("details", registrationDto);
            return "UserPage";
        }
        if (saveTrainDetails.equals("save error")) {
            model.addAttribute("trainMsg", "Enter details correctly");
            model.addAttribute("details", registrationDto);
            return "UserPage";
        } else if (saveTrainDetails.equals("saved Successfully")) {
            model.addAttribute("trainMsg", "Details saved Successfully");
            model.addAttribute("details", registrationDto);
            return "UserPage";
        }
        return "UserPage";
    }

}
