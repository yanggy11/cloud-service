package com.yanggy.cloud.controller.api;

import com.yanggy.cloud.feginclients.ResourceFeiginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/test/**")
public class WebTestController {

	@Autowired
	private ResourceFeiginClient resourceFeiginClient;
	@PostMapping(value="testAuthorize")
	public String testAuthorize(@RequestHeader("Authorization") String Authorization,@RequestBody String string) {
		return string;
	}

	@PostMapping(value = "testFeigin")
	public Object testFeigin() {
		return resourceFeiginClient.getAllRoles();
	}
}
