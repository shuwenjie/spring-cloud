package com.swj.spring.cloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class FilterFunctionConfig {
	
	Logger logger = LoggerFactory.getLogger(FilterFunctionConfig.class);
	
	@Bean
	@Order(-2)
	public GlobalFilter testGlobalFilter(){
		return new GlobalFilter() {
			
			@Override
			public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
				// TODO Auto-generated method stub
				logger.info("testGlobalFilter start");
				return chain.filter(exchange).then(Mono.fromRunnable(() -> {
					logger.info("testGlobalFilter done");
	            }));
			}
		};
	}

}
