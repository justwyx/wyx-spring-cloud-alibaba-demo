package com.wyx.providernacosconfig038081.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author : Just wyx
 * @Date : 2020/12/29
 */
@Configuration
@ConfigurationProperties(prefix = "wyx")
public class WyxConfig {
	private String name;
	private Integer age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}


}
