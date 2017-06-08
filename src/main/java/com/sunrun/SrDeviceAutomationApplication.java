package com.sunrun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class SrDeviceAutomationApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SrDeviceAutomationApplication.class, args);
	}
	
}
