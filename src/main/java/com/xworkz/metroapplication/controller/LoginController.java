package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.DisplayMetroDetailsDto;
import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.service.DisplayMetroDetailsService;
import com.xworkz.metroapplication.service.MetroService;
import com.xworkz.metroapplication.util.EmailClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {
    public static String path = "C://Users//NEW//IdeaProjects//metro-application//fileUploadImages//";

    public LoginController() {
        System.out.println("Login Controller created");
    }

    @Autowired
    MetroService metroService;
    @Autowired
    EmailClass emailClass;
    @Autowired
    DisplayMetroDetailsService metroDetailsService;

    @GetMapping("/getLoginByEmail")
    public String getLogin() {
        return "LoginByEmail";
    }

    @GetMapping("/getIndex")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/getRegistration")
    public String getRegistration() {
        return "Registration";
    }

    @GetMapping("/getForgotPassword")
    public String getForgotPassword() {
        return "ForgotPassword";
    }

    @GetMapping("/getMetroFetch")
    public String getMetroFetch() {
        return "MetroFetch";
    }

    @GetMapping("/getProfileUpdate")
    public String getProfileUpdate() {return "ProfileUpdate";}

    @GetMapping("/getResetPassword")
    public String getResetPassword() {
        return "ResetPassword";
    }
    @GetMapping("/getUserPage")
    public String getUserPage(){
        return "UserPage";
    }


    @PostMapping("/onLoginSaveDetailsByEmail")
    public String onLoginSaveDetailsByEmail(@RequestParam String emailId, @RequestParam String password, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        log.info("login dto email is ===========" + emailId);

        log.info("ON LOGIN SAVE DETAILS BY EMAIL ");
        if (registrationDto == null) {
            model.addAttribute("adminLoginMsg","Enter correct email id");
            return "LoginByEmail";
        }
        if (registrationDto.isAccountBlocked()) {
            model.addAttribute("adminLoginMsg", "User Account is blocked Please reset your password  ");
            model.addAttribute("details", registrationDto);

            return "LoginByEmail";
        } else {
            String message = metroService.onSaveLoginDetailsByEmail(emailId, password);
            if (message.equals("Invalid Login")) {
                model.addAttribute("adminLoginMsg", "Email or  password is incorrect");
                model.addAttribute("details", registrationDto);
                return "LoginByEmail";

            } else if (message.equals("Login Successful")){
                model.addAttribute("adminLoginMsg", "Login Successful");
                model.addAttribute("details", registrationDto);
                return "UserPage";
            }
        }
        return "LoginByEmail";
    }

    @GetMapping("/getOtpDetails")
    public String getOtpDetails(@RequestParam String emailId, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        metroService.onUpdateByEmailId(emailId);
        log.info("the dto provided by email is ==========================");
        log.info(String.valueOf(registrationDto));
        model.addAttribute("emailDto", registrationDto);
        return "ForgotPassword";
    }


    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestParam String otp, @RequestParam String emailId, Model model) {
        if (otp != null && emailId != null) {
            RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
            log.info("emailId is =================  " + emailId);
            boolean isVerifiedOtp = metroService.verifyOtp(emailId, otp);
            if (isVerifiedOtp) {
                model.addAttribute("registrationDto", registrationDto);
                return "ResetPassword";
            } else
                model.addAttribute("Otpmsg", "Enter Correct Otp");
            return "ForgotPassword";
        }
        return "ForgotPassword";
    }

    @PostMapping("/onPasswordReset")
    public String onPasswordReset(String password, String confirmPassword, String emailId, Model model) {
        log.info("onPasswordReset emailId is =================  " + emailId);
        log.info("onPasswordReset password is =================  " + password);
        if (password != null && emailId != null) {
            boolean isPasswordUpdated = metroService.onUpdatePasswordByEmailId(password, confirmPassword, emailId);
            if (isPasswordUpdated) {
                return "LoginByEmail";
            } else
                model.addAttribute("passwordError", "Enter Correct password");
            return "ResetPassword";
        }
        return "LoginByEmail";
    }

    @GetMapping("/editProfile")
    public String getEditProfile(@RequestParam String emailId, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        model.addAttribute("metroDto", registrationDto);

        return "ProfileUpdate";
    }
    @GetMapping("/getMetroDetails")
    public String getMetroDetails(@RequestParam String emailId, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        model.addAttribute("metroDto", registrationDto);
        List<DisplayMetroDetailsDto> metroDetails = metroDetailsService.getMetroDetails();
        if (metroDetails == null) {
            model.addAttribute("DisplayMsg","Data error");
            return "UserPage";
        }
        model.addAttribute("metroInfo",metroDetails);
        return "MetroDetailsAdmin";
    }
    @GetMapping("/getUserPageByMail")
    public String getUserPageByMail(@RequestParam String emailId,Model model){
        log.info(" getUserPageByMail controller begin");
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        model.addAttribute("details", registrationDto);
        return "UserPage";
    }

    @PostMapping("updateDetails")
    public String editRegisterDetails(@RequestParam("file") MultipartFile file, RegistrationDto registrationDto, Model model) {
        boolean updateMessage = metroService.saveEditedProfile(registrationDto, file);
        RegistrationDto registrationDto1 = metroService.onFindByEmailId(registrationDto.getEmailId());

        if (updateMessage) {
            model.addAttribute("msg", "data updated successfully");
            model.addAttribute("details", registrationDto);
        } else {
            model.addAttribute("details", registrationDto1);
            model.addAttribute("errMsg", "data not updated");
        }
        return "UserPage";
    }

    @GetMapping("getImage/{userImage}")
    public void viewImage(@PathVariable String userImage, Model model, HttpServletResponse httpServletResponse, HttpServletRequest httpRequest) {

        File file1 = new File(path + userImage);
        log.info("user image stored is =============   " + userImage);

        try {
            FileInputStream fileInputStream = new FileInputStream(file1);
            InputStream inputStream = new BufferedInputStream(fileInputStream);
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            IOUtils.copy(inputStream, servletOutputStream);
            HttpSession session = httpRequest.getSession(true);
            session.setAttribute("image",servletOutputStream);
            model.addAttribute("image", servletOutputStream);
            httpServletResponse.flushBuffer();
        } catch (IOException e) {
            log.error("error in view image ............ " + e.getMessage());
        }

    }
}

