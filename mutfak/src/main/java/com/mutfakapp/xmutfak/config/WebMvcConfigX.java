package com.mutfakapp.xmutfak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.mutfakapp.xmutfak"})
public class WebMvcConfigX implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver XResolver() {
		InternalResourceViewResolver resolverX = new InternalResourceViewResolver();
		resolverX.setViewClass(JstlView.class);
		resolverX.setPrefix("/WEB-INF/views/");
		resolverX.setSuffix(".jsp");
		return resolverX;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
}

