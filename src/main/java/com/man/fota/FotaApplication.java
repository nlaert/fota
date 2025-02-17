package com.man.fota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FotaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FotaApplication.class, args);
	}

}
