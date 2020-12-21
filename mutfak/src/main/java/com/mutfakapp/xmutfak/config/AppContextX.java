package com.mutfakapp.xmutfak.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class AppContextX {

	@Autowired
	private Environment environmentX;
	
	@Bean
	public LocalSessionFactoryBean XSessionFactory() {
		LocalSessionFactoryBean sessionFactoryX = new LocalSessionFactoryBean();
		sessionFactoryX.setDataSource(dataSource());
		sessionFactoryX.setPackagesToScan(new String[] {"com.mutfakapp.xmutfak.entity"});
		sessionFactoryX.setHibernateProperties(XHibernateProperties());
		return sessionFactoryX;
	}
	
	
	private Properties XHibernateProperties() {
		Properties propertiesX = new Properties();
		propertiesX.put("hibernate.dialect", environmentX.getRequiredProperty("hibernate.dialect"));
		propertiesX.put("hibernate.show_sql",environmentX.getRequiredProperty("hibernate.show_sql"));
		propertiesX.put("hibernate.format_sql", environmentX.getRequiredProperty("hibernate.format_sql"));
		propertiesX.put("hibernate.hbm2ddl.auto", environmentX.getRequiredProperty("hibernate.hbm2ddl"));
		return propertiesX;
	}
	
	private DataSource dataSource() {
		DriverManagerDataSource dataSourceX = new DriverManagerDataSource();
		dataSourceX.setDriverClassName(environmentX.getRequiredProperty("jdbc.driverClassName"));
		dataSourceX.setUrl(environmentX.getRequiredProperty("jdbc.url"));
		dataSourceX.setUsername(environmentX.getRequiredProperty("jdbc.username"));
		dataSourceX.setPassword(environmentX.getRequiredProperty("jdbc.password"));
		return dataSourceX;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManagerX = new HibernateTransactionManager();
		transactionManagerX.setSessionFactory(XSessionFactory().getObject());
		return transactionManagerX;
	}
}
