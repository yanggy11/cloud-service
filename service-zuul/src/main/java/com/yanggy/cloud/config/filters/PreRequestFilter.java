package com.yanggy.cloud.config.filters;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.http.ServletInputStreamWrapper;

import utils.ResponseEntityDto;

/**
 * @author derrick.yang
 * @Date 9/20/18 09:06
 */

public class PreRequestFilter extends ZuulFilter {

	private RestTemplate restTemplate;
	private String authHeader;

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 2;
	}

	@Override
	public boolean shouldFilter() {
		if (RequestContext.getCurrentContext().getRequest().getRequestURI().contains("/api/resources")) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		String token = requestContext.getRequest().getHeader(this.authHeader);

		if (StringUtils.isBlank(token)) {
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(400);
			requestContext.setResponseBody("please login");

			return null;
		}

		// 验证token
		Map<String, String> map = new HashMap<>();
		map.put("token", token);
		ResponseEntityDto<User> response = restTemplate.postForObject("http://RESOURCES/auth/authorization", map,
				ResponseEntityDto.class);
		System.out.println(response);

		if(requestContext.getRequest().getRequestURI().contains("/api/web/upload")) {
			return null;
		}

		InputStream in = null;
		try {
			in = requestContext.getRequest().getInputStream();
			String body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
			JSONObject json = JSONObject.parseObject(body);
			json.put("user", response.getData());
			String newBody = json.toString();
			final byte[] reqBodyBytes = newBody.getBytes();
			requestContext.setRequest(new HttpServletRequestWrapper(requestContext.getRequest()) {
				@Override
				public ServletInputStream getInputStream() throws IOException {
					return new ServletInputStreamWrapper(reqBodyBytes);
				}
				@Override
				public int getContentLength() {
					return reqBodyBytes.length;
				}
				@Override
				public long getContentLengthLong() {
					return reqBodyBytes.length;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public PreRequestFilter(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getAuthHeader() {
		return authHeader;
	}

	public void setAuthHeader(String authHeader) {
		this.authHeader = authHeader;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
