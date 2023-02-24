package com.example.mobilelele.config;

import com.example.mobilelele.models.beans.LoggedUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    @SessionScope
    public LoggedUser loggedUser(){
        return new LoggedUser();
    }
}
