package com.mohameddahmane.config;

import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mohameddahmane.dao.StudentDAO;
import com.mohameddahmane.dao.StudentDAOImp;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.mohameddahmane"})
public class AppConfig implements WebMvcConfigurer{ 
	
	@Autowired 
	ApplicationContext applicationcontext;
	 
	 @Bean 
	 public ViewResolver viewResovlver() {
			 InternalResourceViewResolver internalResourceViewResolver=new
			 InternalResourceViewResolver();
			 internalResourceViewResolver.setPrefix("/WEB-INF/views/");
			 internalResourceViewResolver.setSuffix(".jsp");
			 internalResourceViewResolver.setOrder(0); return
			 internalResourceViewResolver;
	   }
	 
	 @Bean 
	 DriverManagerDataSource getDataSource() {
		 DriverManagerDataSource dataSource=new DriverManagerDataSource();
		 dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 dataSource.setUrl(" jdbc:mysql://127.0.0.1:3306/mohamed?useSSL=false");
		 dataSource.setUsername("root");
		 return dataSource;
		 
	 }
	 @Bean 
	 public StudentDAO getUserdao() {
		 
		 return new StudentDAOImp(getDataSource());
	 }

}
