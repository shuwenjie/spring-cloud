package com.swj.spring.cloud.gateway.router;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.swj.spring.cloud.gateway.service.TestService;

@Configuration
public class RouterFunctionConfig {

	Logger logger = LoggerFactory.getLogger(RouterFunctionConfig.class);

	@Autowired
	StringRedisTemplate redis;

	@Autowired
	TestService service;

	@Bean
	@Order(0)
	public RouterFunction<ServerResponse> IPCHeckRouter() {
		return RouterFunctions.route(request -> !request.headers().host().getHostName().equals("localhost"),
				request -> ServerResponse.ok().body(BodyInserters.fromObject("ip limit")));
	}

	@Bean
	@Order(1)
	public RouterFunction<ServerResponse> checkRouter() {
		return RouterFunctions.route(request -> {
//			logger.info("current thread is " + Thread.currentThread());
//			logger.info("check head");
			List<String> keyHeader = request.headers().header("Authorization");
			if (keyHeader == null || keyHeader.size() == 0 || !keyHeader.get(0).equals("cloud")) {
				return true;
			}

			return false;
		}, request -> ServerResponse.ok().body(BodyInserters.fromObject("check error")));
	}

	@Bean
	@Order(2)
	public RouterFunction<ServerResponse> ProviderRouter() {
		return RouterFunctions.route(RequestPredicates.path("/provider/*"), request -> {
//			redis.opsForValue().set("name", request.queryParam("name").orElse("none"));
			return ServerResponse.ok().body(BodyInserters.fromObject(service.getDemo(request).block()));
		}
		// request ->
		// ServerResponse.ok().body(BodyInserters.fromObject(service.getDemo().block()))
		);
	}
}
