package com.swj.spring.cloud.gateway.controllor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class TestControllor {
	
	@RequestMapping("/test")
	public String test(){
		return "done";
	}

}
