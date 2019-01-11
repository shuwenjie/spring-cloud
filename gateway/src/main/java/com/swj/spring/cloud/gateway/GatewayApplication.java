package com.swj.spring.cloud.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.swj.spring.cloud.common.CustomSpringApplication;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) throws Exception {
		CustomSpringApplication.start(GatewayApplication.class, args);
	}

}
