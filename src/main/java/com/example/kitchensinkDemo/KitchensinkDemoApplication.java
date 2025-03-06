package com.example.kitchensinkDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class KitchensinkDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitchensinkDemoApplication.class, args);
	}

}
