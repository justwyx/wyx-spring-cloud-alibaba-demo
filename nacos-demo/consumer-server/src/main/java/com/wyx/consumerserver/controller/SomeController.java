package com.wyx.consumerserver.controller;

import com.wyx.consumerserver.sao.UserFeignClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : Just wyx
 * @Date : 2021/2/25
 */
// @RefreshScope 添加该注解，可动态更新@Value
@RefreshScope
@RequestMapping("/some")
@RestController
public class SomeController {
	@Value("${prefix:}")
	private String prefix;

	@Resource
	private UserFeignClient userFeignClient;

	@GetMapping(value = "/getPrefix")
	public String getPrefix (){
		return prefix;
	}

	@GetMapping(value = "/getUserId")
	public Integer getUserId (){
		return userFeignClient.getUserId();
	}
}
