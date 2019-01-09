package com.swj.spring.cloud.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.swj.spring.cloud.common.CustomSpringApplication;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {
		CustomSpringApplication.start(EurekaApplication.class, args);
	}
}
