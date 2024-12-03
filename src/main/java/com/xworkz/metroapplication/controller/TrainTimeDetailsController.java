package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.service.MetroService;
import com.xworkz.metroapplication.service.StationDetailsService;
import com.xworkz.metroapplication.service.TrainTimeDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("addTrainTimeDetails")
    public String addTrainTimeDetails(@Valid TrainTimeDetailsDto trainTimeDetailsDto, String emailId, BindingResult bindingResult, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        if (bindingResult.hasErrors()) {
            model.addAttribute("TimeDetailsMsg", "Please Enter Correct Details");
            model.addAttribute("details", registrationDto);
            return "AdminPage";
        }
        String onSaveTimeDetails = timeDetailsService.onSaveTimeDetails(trainTimeDetailsDto);
        if (onSaveTimeDetails.equals("Data Saved")) {
            List<StationDetailsDto> stationDetailsDtoList = stationDetailsService.onFindAll();
            model.addAttribute("TimeDetailsMsg","Data Saved Successfully");
            model.addAttribute("details", registrationDto);
            model.addAttribute("stationDetailsDtoList",stationDetailsDtoList);
            return "AdminPage";
        } else if (onSaveTimeDetails.equals("Data Error")) {
            model.addAttribute("TimeDetailsMsg","Error in Data ");
            model.addAttribute("details", registrationDto);
            return "AdminPage";
        }
        return "AdminPage";
    }

}
