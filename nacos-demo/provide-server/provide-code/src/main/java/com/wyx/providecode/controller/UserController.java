package com.wyx.providecode.controller;

import com.wyx.feign.UserFeign;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Just wyx
 * @Date : 2021/2/25
 */
@RestController
public class UserController implements UserFeign {

	@Override
	public Integer getUserId(){
		return 1;
	}
}
