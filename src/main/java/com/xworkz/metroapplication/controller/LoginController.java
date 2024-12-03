package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.service.MetroService;
import com.xworkz.metroapplication.service.StationDetailsService;
import com.xworkz.metroapplication.util.EmailClass;
import com.xworkz.metroapplication.util.Encryption;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MetroService metroService;
    @Autowired
    private EmailClass emailClass;
    @Autowired
    private Encryption encryption;
    @Autowired
    private StationDetailsService stationDetailsService;

    @GetMapping("/getAdminLogin")
    public String getAdminLogin() {
        return "LoginByEmail";
    }

    @GetMapping("/getIndex")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/getLoginPage")
    public String getLoginPage() {
        return "LoginPage";
    }

    @GetMapping("/getForgotPassword")
    public String getForgotPassword() {
        return "ForgotPassword";
    }
    @GetMapping("/getProfileUpdate")
    public String getProfileUpdate() {
        return "ProfileUpdate";
    }

    @GetMapping("/getResetPassword")
    public String getResetPassword() {
        return "ResetPassword";
    }

    @PostMapping("/onLoginSaveDetailsByEmail")
    public String onLoginSaveDetailsByEmail(@RequestParam String emailId, @RequestParam String password, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        if (registrationDto == null) {
            model.addAttribute("adminLoginMsg", "Enter correct email id");
            return "LoginByEmail";
        }else {
        if (registrationDto.isAccountBlocked()) {
            model.addAttribute("adminLoginMsg", "User Account is blocked Please reset your password  ");
            model.addAttribute("details", registrationDto);
            return "LoginByEmail";
        }
        String message = metroService.onSaveLoginDetailsByEmail(emailId, password);
        if (message.equals("Invalid Login")) {
            model.addAttribute("adminLoginMsg", "Email or  password is incorrect");
            model.addAttribute("details", registrationDto);
            return "LoginByEmail";
        } else if (message.equals("Login Successful")) {
            List<StationDetailsDto> stationDetailsDtoList = stationDetailsService.onFindAll();
            model.addAttribute("adminLoginSuccessMsg", "Login Successful");
            model.addAttribute("details", registrationDto);
            model.addAttribute("stationDetailsDtoList",stationDetailsDtoList);
            return "AdminPage";
        }
        }
        return "LoginByEmail";
    }

    @GetMapping("/getOtpDetails")
    public String getOtpDetails(@RequestParam String emailId, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        String updateByEmailId = metroService.onUpdateByEmailId(emailId);
        if(updateByEmailId.equalsIgnoreCase("Otp Sent Successfully")){
        model.addAttribute("emailDto", registrationDto);
        model.addAttribute("otpSuccessMessage", "Otp Sent Successfully");
        return "ForgotPassword";
        }
        model.addAttribute("otpErrorMessage", "Can't find email");
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
                model.addAttribute("OtpSuccessMsg", "Otp verified ");
                return "ResetPassword";
            } else
                model.addAttribute("OtpErrorMsg", "Enter Correct Otp");
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
                model.addAttribute("passwordSuccess", "Password Updated");
                return "ResetPassword";
            } else
                model.addAttribute("passwordError", "Enter Correct password");
            return "ResetPassword";
        }
        model.addAttribute("passwordError", "Enter Valid details ");
        return "ResetPassword";
    }

    @GetMapping("/editProfile")
    public String getEditProfile(@RequestParam String emailId, Model model) {
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        log.info("image name is ========== " + registrationDto.getUserImage());
        registrationDto.setPassword(encryption.decrypt(registrationDto.getPassword()));
        model.addAttribute("metroDto", registrationDto);
        return "ProfileUpdate";
    }

    @GetMapping("/getAdminPageByMail")
    public String getAdminPageByMail(@RequestParam String emailId, Model model) {
        log.info(" getAdminPageByMail controller begin");
        RegistrationDto registrationDto = metroService.onFindByEmailId(emailId);
        model.addAttribute("details", registrationDto);
        return "AdminPage";
    }

    @PostMapping("updateDetails")
    public String editRegisterDetails(@RequestParam("file") MultipartFile file, RegistrationDto registrationDto, Model model) {
        RegistrationDto registrationDto1 = metroService.onFindByEmailId(registrationDto.getEmailId());
       log.info("file sent is =============   {}",file);
        boolean updateMessage = metroService.saveEditedProfile(registrationDto, file);
        if (updateMessage) {
            model.addAttribute("msg", "data updated successfully");
            model.addAttribute("details", registrationDto);
        } else {
            model.addAttribute("details", registrationDto1);
            model.addAttribute("errMsg", "data not updated");
        }
        return "AdminPage";
    }

    @GetMapping("getImage/{userImage}")
    public void viewImage(@PathVariable String userImage, Model model, HttpServletResponse httpServletResponse, HttpServletRequest httpRequest) {
        File file1 = new File(path + userImage);
        try {
            FileInputStream fileInputStream = new FileInputStream(file1);
            InputStream inputStream = new BufferedInputStream(fileInputStream);
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            IOUtils.copy(inputStream, servletOutputStream);
            HttpSession session = httpRequest.getSession(true);
            session.setAttribute("image", servletOutputStream);
            model.addAttribute("image", servletOutputStream);
            httpServletResponse.flushBuffer();
        } catch (IOException e) {
            log.error("error in view image ............ " + e.getMessage());
        }

    }
}

