package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.DisplayMetroDetailsDto;
import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.service.DisplayMetroDetailsService;
import com.xworkz.metroapplication.service.MetroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
@RequestMapping("/")
@Slf4j
public class MetroInfoController {
    @Autowired
    private MetroService metroService;
    @Autowired
    private DisplayMetroDetailsService  metroDetailsService;
    @GetMapping("/getMetroDetails")
    public String getMetroDetails(@RequestParam String emailId, Model model) {

        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        log.info(" =============onFindByEmailId in  getMetroDetails ========== ");
        log.info("=====================onFindByEmailId in  getMetroDetails dto details is ========== "+registrationDto);
        model.addAttribute("metroDto", registrationDto);

        List<DisplayMetroDetailsDto> metroDetails = metroDetailsService.getMetroDetails();
        log.info(" =============getMetroDetails in  getMetroDetails ========== " +metroDetails);
        if (metroDetails == null) {
            model.addAttribute("DisplayMsg","Data error");
            return "AdminPage";
        }
        model.addAttribute("metroInfo",metroDetails);
        return "MetroDetailsAdmin";
    }



}
