package com.mutfakapp.xmutfak.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializerX extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {AppContextX.class};
		
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {WebMvcConfigX.class};
		
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}

}
