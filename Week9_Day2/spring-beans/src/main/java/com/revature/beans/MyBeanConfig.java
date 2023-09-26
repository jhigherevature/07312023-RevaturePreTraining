package com.revature.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MyBeanConfig {

	@Bean(initMethod="customInit", destroyMethod="customDestroy")
	@Lazy
	public MyBean myBean() {
		return new MyBean();
	}
}
