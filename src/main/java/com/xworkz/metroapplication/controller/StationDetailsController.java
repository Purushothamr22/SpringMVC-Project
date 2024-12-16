package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.service.MetroService;
import com.xworkz.metroapplication.service.StationDetailsService;
import com.xworkz.metroapplication.service.UserInteractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getStationDetails")
    public String getStationDetails(@RequestParam String emailId, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        model.addAttribute("details", registrationDto);
        return "AddStationDetails";
    }


    @PostMapping("/addStationDetails")
    public String addStationDetails(@Valid StationDetailsDto addStationDetailsDto, String emailId, BindingResult bindingResult, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        String saveTrainDetails = stationDetailsService.saveTrainDetails(addStationDetailsDto);

        if (bindingResult.hasErrors()) {
            model.addAttribute("trainMsg", "Error in saving");
            model.addAttribute("details", registrationDto);
            return "AddStationDetails";
        }
        if (saveTrainDetails.equals("save error")) {
            model.addAttribute("trainMsg", "Enter details correctly");
            model.addAttribute("details", registrationDto);
            return "AddStationDetails";
        } else if (saveTrainDetails.equals("saved Successfully")) {
            model.addAttribute("trainMsg", "Details saved Successfully");
            model.addAttribute("details", registrationDto);
            return "AddStationDetails";
        }
        return "AddStationDetails";
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

    @GetMapping("/getByStationName")
    public String getByStationName( @RequestParam String stationName,@RequestParam String emailId, Model model){
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        StationDetailsDto stationDetailsDto = stationDetailsService.onFindByStationNameService(stationName);
        log.info("User Dto is given as :: ================== {}",registrationDto);
        model.addAttribute("stationDetailsDtoList",stationDetailsDto);
        model.addAttribute("metroDto",registrationDto);
        return "UpdatedDetails";
    }

    @GetMapping("/getEditMetroDetails")
    public String getEditMetroDetails(@RequestParam String source, @RequestParam String destination, @RequestParam String emailId, @RequestParam String stationId, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        StationDetailsDto stationDetailsDto = stationDetailsService.onFindByStationId(Integer.valueOf(stationId));
        TrainTimeDetailsDto trainTimeDetailsDto = userInteractionService.onFindSourceDestinationDetails(source, destination);
        model.addAttribute("metroDto",registrationDto);
        model.addAttribute("trainDetails",trainTimeDetailsDto);
        model.addAttribute("stationDetails",stationDetailsDto);
        return "EditMetroDetails";
    }

    @PostMapping("/editMetroDetails")
    public  String editMetroDetails(TrainTimeDetailsDto trainTimeDetailsDto,StationDetailsDto stationDetailsDto, Model model){
        log.info("train dto is ============== {}",trainTimeDetailsDto);
        log.info("station dto is ================ {}",stationDetailsDto);
        String updateMetroDetails = stationDetailsService.updateMetroDetails(stationDetailsDto, trainTimeDetailsDto);
        if (updateMetroDetails.equalsIgnoreCase("Save success")) {
            return "UpdatedDetails";
        }
        return "EditMetroDetails";
    }
    



}
