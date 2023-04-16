package com.pidev.welend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WeLendApplication {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(WeLendApplication.class, args);
	}

}
