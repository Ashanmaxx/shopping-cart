package com.shoppingcart.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
//@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
@EnableConfigurationProperties
@ConfigurationProperties
public class DatabaseConfig {

	@Autowired
	private Environment env;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;

	@Bean
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		//driverManagerDataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		driverManagerDataSource.setUrl(env.getProperty("spring.datasource.url"));
		driverManagerDataSource.setUsername(env.getProperty("spring.datasource.username"));
		driverManagerDataSource.setPassword(env.getProperty("spring.datasource.password"));
		return driverManagerDataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		localContainerEntityManagerFactoryBean.setDataSource(dataSource);

		// Classpath scanning of @Component, @Service, etc annotated class
		localContainerEntityManagerFactoryBean.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));

		// Vendor adapter
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

		// Hibernate properties
		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		additionalProperties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		localContainerEntityManagerFactoryBean.setJpaProperties(additionalProperties);
		return localContainerEntityManagerFactoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
