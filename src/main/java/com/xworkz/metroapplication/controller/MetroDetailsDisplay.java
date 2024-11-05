package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.DisplayMetroDetailsDto;
import com.xworkz.metroapplication.service.DisplayMetroDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/")
public class MetroDetailsDisplay {
    @Autowired
    DisplayMetroDetailsService metroDetailsService;

    @GetMapping("displayMetroInfo")
    public String displayMetroInfo(Model model){

        List<DisplayMetroDetailsDto> metroDetails = metroDetailsService.getMetroDetails();
        if (metroDetails == null) {
            model.addAttribute("DisplayMsg","Data error");
            return "UserPage";
        }
        model.addAttribute("metroInfo",metroDetails);
        return "MetroDetailsAdmin";

    }
}
