package com.swj.spring.cloud.gateway.flow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class FlowFunctionConfig {
	
	Logger logger = LoggerFactory.getLogger(FlowFunctionConfig.class);

	@Bean
	public KeyResolver userLimit() {
		
		return new KeyResolver() {

			@Override
			public Mono<String> resolve(ServerWebExchange exchange) {
				// TODO Auto-generated method stub
				
				logger.info("limit begin");
				String name = exchange.getRequest().getRemoteAddress().getHostName();
				return name.length() == 0 ? Mono.just("default") : Mono.just(name);
			}
		};
		// return exchange ->
		// Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
		// KeyResolver
	}

}
