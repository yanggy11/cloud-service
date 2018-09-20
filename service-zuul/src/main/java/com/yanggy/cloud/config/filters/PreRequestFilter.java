package com.yanggy.cloud.config.filters;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

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
        return 1;
    }

    @Override
    public boolean shouldFilter() {
    	if(RequestContext.getCurrentContext().getRequest().getRequestURI().contains("/api/resources")) {
    		return false;
    	}
        return true;
    }

    @Override
    public Object run() throws ZuulException {
    	RequestContext requestContext = RequestContext.getCurrentContext();
    	String token = requestContext.getRequest().getHeader(this.authHeader);
    	
    	if(StringUtils.isBlank(token)) {
    		requestContext.setSendZuulResponse(false);
    		requestContext.setResponseStatusCode(400);
    		requestContext.setResponseBody("please login");
    		
    		return null;
    	}
    	
    	//验证token
    	Map<String, String> map = new HashMap<>();
    	map.put("token", token);
        ResponseEntityDto<?> response = restTemplate.postForObject("http://RESOURCES/auth/authorization", map,ResponseEntityDto.class);
        System.out.println(response.getData());
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
