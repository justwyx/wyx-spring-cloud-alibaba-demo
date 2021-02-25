package com.wyx.consumerserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Just wyx
 * @Date : 2021/2/25
 */
@RequestMapping("/some")
@RestController
public class SomeController {
	@Value("${prefix}")
	private String prefix;

	@GetMapping(value = "/getPrefix")
	public String getPrefix (){
		return prefix;
	}
}
