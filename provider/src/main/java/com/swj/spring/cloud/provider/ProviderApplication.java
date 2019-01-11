package com.swj.spring.cloud.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.swj.spring.cloud.common.CustomSpringApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {

	public static void main(String[] args) throws Exception {
		CustomSpringApplication.start(ProviderApplication.class, args);
	}

}
