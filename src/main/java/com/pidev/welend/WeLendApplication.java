package com.pidev.welend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeLendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeLendApplication.class, args);
    }

}
