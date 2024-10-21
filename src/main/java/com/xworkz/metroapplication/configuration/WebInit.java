package com.xworkz.metroapplication.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

@Slf4j
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {
    private int maxUploadSizeInMb = 5 * 1024 * 1024;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        log.info("logger getRootConfigClasses");

        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {


        log.info("logger getServletConfigClasses");
        return new Class[]{(SpringConfiguration.class)};
    }

    @Override
    protected String[] getServletMappings() {

        log.info("logger getServletMappings");
        return new String[]{"/"};
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        log.info("logger ");
        configurer.enable();
    }
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        // upload temp file will put here
        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

        // register a MultipartConfigElement
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                        maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);

        registration.setMultipartConfig(multipartConfigElement);

    }
}
