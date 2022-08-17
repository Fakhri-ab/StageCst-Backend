package com.example.stageversion;

import com.example.stageversion.service.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StageVersionApplication {

    @Autowired
    private SendMail service;
    public static void main(String[] args) {
        SpringApplication.run(StageVersionApplication.class, args);
    }

}
