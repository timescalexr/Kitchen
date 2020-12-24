package com.mutfakapp.xmutfak.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
 
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
 
public class AppInitializerX implements WebApplicationInitializer {
 
  @Override
  public void onStartup(ServletContext sc) throws ServletException {
    AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
    root.scan("com.mutfakapp");
    root.setConfigLocation(WebMvcConfigX.class.getName());
 
    sc.addListener(new ContextLoaderListener(root));
    
    FilterRegistration.Dynamic securityFilter = sc.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
    securityFilter.addMappingForUrlPatterns(null, false, "/*");
    
    
    AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
    webContext.register(WebMvcConfigX.class);
    webContext.setServletContext(sc);
 
    ServletRegistration.Dynamic appServlet = sc.addServlet("appServlet",
        new DispatcherServlet(new GenericWebApplicationContext()));
    appServlet.setLoadOnStartup(1);
    appServlet.addMapping("/*");
  }
}

/*import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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

}*/
