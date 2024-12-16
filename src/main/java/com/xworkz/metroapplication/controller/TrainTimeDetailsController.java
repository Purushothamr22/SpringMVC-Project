package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.service.MetroService;
import com.xworkz.metroapplication.service.StationDetailsService;
import com.xworkz.metroapplication.service.TrainTimeDetailsService;
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
public class TrainTimeDetailsController {
    @Autowired
    private TrainTimeDetailsService timeDetailsService;
    @Autowired
    private MetroService metroService;
    @Autowired
    private StationDetailsService stationDetailsService;

    public TrainTimeDetailsController() {
        log.info("TrainTimeDetails Controller created ");
    }

    @GetMapping("/getTimeDetails")
    public  String getTimeDetails(@RequestParam String emailId,Model model){
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        List<StationDetailsDto> stationDetailsDtoList = stationDetailsService.onFindAll();
        model.addAttribute("stationDetailsDtoList", stationDetailsDtoList);
        model.addAttribute("details",registrationDto);
        return "TrainTimeDetails";
    }


    @PostMapping("addTrainTimeDetails")
    public String addTrainTimeDetails(@Valid TrainTimeDetailsDto trainTimeDetailsDto, String emailId, BindingResult bindingResult, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        List<StationDetailsDto> stationDetailsDtoList = stationDetailsService.onFindAll();
        if (bindingResult.hasErrors()) {
            model.addAttribute("TimeDetailsMsg", "Please Enter Correct Details");
            model.addAttribute("details", registrationDto);
            model.addAttribute("stationDetailsDtoList",stationDetailsDtoList);
            return "TrainTimeDetails";
        }
        String onSaveTimeDetails = timeDetailsService.onSaveTimeDetails(trainTimeDetailsDto);
        if (onSaveTimeDetails.equals("Data Saved")) {
            model.addAttribute("TimeDetailsMsg","Data Saved Successfully");
            model.addAttribute("details", registrationDto);
            model.addAttribute("stationDetailsDtoList",stationDetailsDtoList);
            return "TrainTimeDetails";
        }
        return "TrainTimeDetails";
    }



}
