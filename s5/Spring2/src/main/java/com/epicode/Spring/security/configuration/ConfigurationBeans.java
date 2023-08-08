package com.epicode.Spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.Spring.security.entity.Laptop;
import com.epicode.Spring.security.entity.Smartphone;
import com.epicode.Spring.security.entity.Tablet;

@Configuration
public class ConfigurationBeans {
	
	@Bean("smartphoneBean")
	@Scope("prototype")
	public Smartphone smartphone() {
		return new Smartphone();
	}
	
	@Bean("laptopBean")
	@Scope("prototype")
	public Laptop laptop() {
		return new Laptop();
	}
	
	@Bean("tabletBean")
	@Scope("prototype")
	public Tablet tablet() {
		return new Tablet();
	}
}
