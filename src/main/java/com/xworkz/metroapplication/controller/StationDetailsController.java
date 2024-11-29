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
    private   MetroService metroService;

    @GetMapping("/getAdminPage")
    public String getAdminPage(){
        return "AdminPage";
    }
    @PostMapping("/addStationDetails")
    public String addStationDetails(@Valid StationDetailsDto addStationDetailsDto, String emailId, BindingResult bindingResult, Model model) {

        log.error(emailId + " ============== is the given email id ");
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        String saveTrainDetails = stationDetailsService.saveTrainDetails(addStationDetailsDto);

        if (bindingResult.hasErrors()) {
            model.addAttribute("trainMsg", "Error in saving");
            model.addAttribute("details", registrationDto);
            return "AdminPage";
        }
        if (saveTrainDetails.equals("save error")) {
            model.addAttribute("trainMsg", "Enter details correctly");
            model.addAttribute("details", registrationDto);
            return "AdminPage";
        } else if (saveTrainDetails.equals("saved Successfully")) {
            model.addAttribute("trainMsg", "Details saved Successfully");
            model.addAttribute("details", registrationDto);
            return "AdminPage";
        }
        return "AdminPage";
    }

    @GetMapping("/getDetails")
    public String getDetails(@RequestParam String emailId, Model model){
            RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        log.info(" =============onFindByEmailId in  getMetroDetails ========== ");
        log.info("=====================onFindByEmailId in  getMetroDetails dto details is ========== "+registrationDto);
        model.addAttribute("metroDto", registrationDto);

        List<StationDetailsDto> stationDetailsDtoList = stationDetailsService.onFindAll();
        log.info(" =============stationDetailsService in  onFindAllDetails ========== "+stationDetailsDtoList);
        if (stationDetailsDtoList == null) {
            model.addAttribute("DisplayMsg","Data error");
            return "AdminPage";
        }
        model.addAttribute("metroInfo",stationDetailsDtoList);
        return "MetroDetailsAdmin";
    }

}
