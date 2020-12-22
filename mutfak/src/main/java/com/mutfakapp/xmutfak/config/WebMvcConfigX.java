package com.mutfakapp.xmutfak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.mutfakapp.xmutfak"})
@Import({ WebSecurityConfig.class })
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
	
  	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}

