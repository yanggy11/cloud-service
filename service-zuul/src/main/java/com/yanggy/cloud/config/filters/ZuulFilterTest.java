package com.yanggy.cloud.config.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.web.client.RestTemplate;

/**
 * @author derrick.yang
 * @Date 9/20/18 09:06
 */
public class ZuulFilterTest extends ZuulFilter {

    private RestTemplate restTemplate;
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
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        Object response = restTemplate.getForObject("http://RESOURCES/test", Object.class);

        System.out.println(response);
        return null;
    }

    public ZuulFilterTest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
