package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.service.MetroService;
import com.xworkz.metroapplication.util.EmailClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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

        if (registrationDto.isAccountBlocked()) {
            model.addAttribute("userLoginMsg", "User Account is blocked Please reset your password  ");
            model.addAttribute("details", registrationDto);
            model.addAttribute("AccBlockDetails", registrationDto.getNoOfAttempts());
            return "LoginByEmail";
        } else {
            String message = metroService.onSaveLoginDetailsByEmail(emailId, password);
            if (message.equals("Invalid Login")) {
                model.addAttribute("userLoginMsg", "Email or  password is incorrect");
                model.addAttribute("details", registrationDto);
                return "LoginByEmail";

            } else {
                model.addAttribute("userLoginMsg", message);
                model.addAttribute("details", registrationDto);
                return "UserPage";
            }
        }
    }

    @GetMapping("/getOtpDetails")
    public String getOtpDetails(@RequestParam String emailId, String otp, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        metroService.onUpdateByEmailId(emailId, otp);
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
            log.info("onPasswordReset password is =================  " + password);
            log.info("onPasswordReset confirm password is =================  " + confirmPassword);
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
    public void viewImage(@PathVariable String userImage, Model model, HttpServletResponse httpServletResponse) {

        File file1 = new File(path + userImage);
        log.info("user image stored is =============   " + userImage);

        try {
            FileInputStream fileInputStream = new FileInputStream(file1);
            InputStream inputStream = new BufferedInputStream(fileInputStream);
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            IOUtils.copy(inputStream, servletOutputStream);
            model.addAttribute("image", servletOutputStream);
            httpServletResponse.flushBuffer();
        } catch (IOException e) {
            log.error("error in view image ............ " + e.getMessage());
        }

    }
}

