package com.swj.spring.cloud.common;

import org.springframework.boot.CustomBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.SimpleCommandLinePropertySource;

public class CustomSpringApplication {

	private final static String SPRING_PROFILES_ACTIVE = "spring.profiles.active";

	private final static String SPRING_CONFIG_LOCATION = "spring.config.location";

	public static void start(Class<?> clz, String[] args) {
		args = addDefaultProfile(args);
		SimpleCommandLinePropertySource startedParams = new SimpleCommandLinePropertySource(args);
		String location = "";
		if (startedParams.containsProperty(SPRING_CONFIG_LOCATION)) {
			location = startedParams.getProperty(SPRING_CONFIG_LOCATION);
			String[] newArgs = new String[args.length - 1];
			int index = 0;
			for (int i = 0; i < args.length; i++) {
				if (!args[i].startsWith("--" + SPRING_CONFIG_LOCATION)) {
					newArgs[index++] = args[i];
				}
			}
			args = newArgs;
		}
		if (startedParams.containsProperty(SPRING_PROFILES_ACTIVE)) {
			location = (location.length() == 0 ? "" : location + ",") + "classpath:/,classpath:/"
					+ startedParams.getProperty(SPRING_PROFILES_ACTIVE) + "/";

		}
		System.setProperty("spring.config.location", location);
		SpringApplication application = new SpringApplication(clz);
		application.setBanner(new CustomBanner());
		application.run(args);
	}

	private static String[] addDefaultProfile(String[] args) {
		String[] newArgs = new String[args.length + 1];
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("--" + SPRING_PROFILES_ACTIVE)) {
				return args;
			}
			newArgs[i] = args[i];
		}
		newArgs[args.length] = "--" + SPRING_PROFILES_ACTIVE + "=dev";
		return newArgs;

	}

}
