package com.wyx.consumer018080.coderconfig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DepartCodeConfig {
    @LoadBalanced  // 负载均衡方式
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
