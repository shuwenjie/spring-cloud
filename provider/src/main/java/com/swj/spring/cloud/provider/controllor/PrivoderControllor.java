package com.swj.spring.cloud.provider.controllor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/privoder")
public class PrivoderControllor {

	@GetMapping(name="/value")
	public String privoderValue(@RequestParam(required = false, name = "name", defaultValue = "default") String name) {
		return "success," + name;
	}

}
