package com.yanggy.cloud.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test/**")
public class WebTestController {
	@PostMapping(value="testAuthorize")
	public String testAuthorize() {
		return "success";
	}

}
