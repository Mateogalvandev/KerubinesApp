package com.kerubinessys.v0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class V0Application {

	public static void main(String[] args) {
		SpringApplication.run(V0Application.class, args);
	}

}
