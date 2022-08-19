package com.mohameddahmane.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MainApp  implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);
		ServletRegistration.Dynamic serDynamic=servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		serDynamic.setLoadOnStartup(1);
		serDynamic.addMapping("/");
		context.close();
		
	}

}
