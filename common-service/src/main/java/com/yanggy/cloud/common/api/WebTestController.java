package com.yanggy.cloud.common.api;

import com.yanggy.cloud.common.feginclients.ResourceFeiginClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/test/**")
public class WebTestController {

	private static Logger logger = LoggerFactory.getLogger(WebTestController.class);

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

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

	@PostMapping(value = "notes")
	public Object notes(@RequestBody String notes) {
//		JSONObject jo = new JSONObject(notes);
//		int ret = jo.getInt("result");
//		if (ret != 0) {
//			throw new IllegalArgumentException("笔记内容错误:result");
//		}
//
//		JSONObject data = jo.getJSONObject("data");
//		JSONArray ja = data.getJSONArray("notes");
//		if (ja.length() <= 0) {
//			throw new IllegalArgumentException("笔记内容错误:notes");
//		}
//
//		for (int i = 0; i < ja.length(); i++) {
//			JSONObject noteJo = ja.getJSONObject(i);
//			String id = noteJo.getString("id");
//			String title = noteJo.getString("share_title");
//
//
//		}
		logger.info("hello", "hello");
		return notes;
	}
}
