package com.swj.spring.cloud.gateway.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;

import com.alibaba.fastjson.JSONObject;

import reactor.core.publisher.Mono;

@Service
public class TestService {

	Logger logger = Logger.getLogger(TestService.class);
	
	@Autowired
	StringRedisTemplate redis;

	public Mono<JSONObject> getDemo(ServerRequest request) {
		logger.info("current thread is " + Thread.currentThread() + " ");
		JSONObject json = new JSONObject();
		json.put("path", request.path());
		json.put("name", redis.opsForValue().get("name"));
		return Mono.just(json);
	}

}
