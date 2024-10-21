package com.xworkz.metroapplication.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("com.xworkz.metroapplication")
@Configuration
@EnableWebMvc
@Slf4j
public class SpringConfiguration {
    public SpringConfiguration() {
        log.info("Spring configuration instance created ");
        System.out.println("spring Configuration instance created");
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        log.info("viewResolver initialized");
        return new InternalResourceViewResolver("/",".jsp");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        log.info("Entity Manager Factory bean created");
        return localContainerEntityManagerFactoryBean;
    }
    @Bean
    public MultipartResolver multipartResolver(){
        return new  StandardServletMultipartResolver();
    }


}
