package com.wyx.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Just wyx
 * @Date : 2021/2/25
 */
@RequestMapping("/user")
public interface UserFeign {

	@GetMapping(value = "/getUserId")
	Integer getUserId();
}
