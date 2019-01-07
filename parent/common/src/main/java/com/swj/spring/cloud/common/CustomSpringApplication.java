package com.swj.spring.cloud.common;

import org.springframework.boot.CustomBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.SimpleCommandLinePropertySource;

public class CustomSpringApplication {

	private final static String SPRING_PROFILES_ACTIVE = "spring.profiles.active";

	public static void start(Class<?> clz, String[] args) {
		SimpleCommandLinePropertySource startedParams = new SimpleCommandLinePropertySource(args);
		if (startedParams.containsProperty(SPRING_PROFILES_ACTIVE)) {
			System.setProperty("spring.config.location",
					"classpath:/,classpath:/" + startedParams.getProperty(SPRING_PROFILES_ACTIVE) + "/");

		}
		SpringApplication application = new SpringApplication(clz);
		application.setBanner(new CustomBanner());
		application.run(args);
	}

}
