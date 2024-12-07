package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.service.MetroService;
import com.xworkz.metroapplication.service.StationDetailsService;
import com.xworkz.metroapplication.service.UserInteractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j

public class StationDetailsController {
    public StationDetailsController() {
        log.info("AddTrainDetailsController controller created");
    }
    @Autowired
    private StationDetailsService stationDetailsService;
    @Autowired
    private UserInteractionService userInteractionService;
    @Autowired
    private MetroService metroService;
    @PostMapping("/addStationDetails")
    public String addStationDetails(@Valid StationDetailsDto addStationDetailsDto, String emailId, BindingResult bindingResult, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        String saveTrainDetails = stationDetailsService.saveTrainDetails(addStationDetailsDto);
        List<StationDetailsDto> stationDetailsDtoList = userInteractionService.onFindStationDetails();

        if (bindingResult.hasErrors()) {
            model.addAttribute("trainMsg", "Error in saving");
            model.addAttribute("details", registrationDto);
            model.addAttribute("stationDetailsDtoList",stationDetailsDtoList);
            return "AdminPage";
        }
        if (saveTrainDetails.equals("save error")) {
            model.addAttribute("trainMsg", "Enter details correctly");
            model.addAttribute("details", registrationDto);
            model.addAttribute("stationDetailsDtoList",stationDetailsDtoList);
            return "AdminPage";
        } else if (saveTrainDetails.equals("saved Successfully")) {
            model.addAttribute("trainMsg", "Details saved Successfully");
            model.addAttribute("details", registrationDto);
            model.addAttribute("stationDetailsDtoList",stationDetailsDtoList);
            return "AdminPage";
        }
        return "AdminPage";
    }
    @GetMapping("/getDetails")
    public String getDetails(@RequestParam String emailId, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        model.addAttribute("metroDto", registrationDto);
        List<StationDetailsDto> stationDetailsDtoList = stationDetailsService.onFindAll();
        if (stationDetailsDtoList != null) {
            model.addAttribute("stationDetailsDtoList", stationDetailsDtoList);
            return "MetroDetailsAdmin";
        }
        model.addAttribute("DisplayMsg", "Data error");
        return "MetroDetailsAdmin";
    }

}
