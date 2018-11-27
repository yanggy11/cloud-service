package com.yanggy.cloud.common.api;

import com.yanggy.cloud.common.dto.vo.RoleVo;
import com.yanggy.cloud.common.dto.vo.UserVo;
import com.yanggy.cloud.common.feginclients.ResourceFeiginClient;
import com.yanggy.cloud.common.utils.ResponseEntityBuilder;
import com.yanggy.cloud.common.utils.ResponseEntityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
		List<RoleVo> roles = (List<RoleVo>) redisTemplate.opsForValue().get("roles:test:1");

		if(null == roles || roles.size() <= 0) {
			ResponseEntityDto<List<RoleVo>> res = resourceFeiginClient.getAllRoles();

			if(null != res && "1".equals(res.getStatus()) && null != res.getData()) {
				redisTemplate.opsForValue().set("roles:test:1", res.getData());
				redisTemplate.expire("roles:test:1", 10000, TimeUnit.MILLISECONDS);
			}

			roles = res.getData();
		}

		return ResponseEntityBuilder.buildNormalResponseEntity(roles);
	}

	@PostMapping(value = "getUserById")
	public ResponseEntityDto<?> getUserInfo(@RequestBody UserVo userVo) {

		UserVo user = (UserVo) redisTemplate.opsForValue().get("user:info:test:" + userVo.getId());

		if(null == user) {
			Map<String, Long> map = new HashMap<>();
			map.put("userId", userVo.getId());
			ResponseEntityDto<UserVo> res = resourceFeiginClient.getUserById(map);
			if(null != res && "1".equals(res.getStatus()) && null != res.getData()) {
				redisTemplate.opsForValue().set("user:info:test:" + userVo.getId(), res.getData());
				redisTemplate.expire("user:info:test:" + userVo.getId(), 60000, TimeUnit.MILLISECONDS);
			}

			user = res.getData();
		}

		return ResponseEntityBuilder.buildNormalResponseEntity(user);
	}
}
