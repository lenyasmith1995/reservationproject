package com.example.newreserve;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.example")
public class AppConfig {

	/*
	 * @Autowired Environment environment; private final String URL =
	 * "//192.168.1.110:1433; databaseName = reservationproject ; encrypt=false;";
	 * private final String USER = "requestclient"; private final String DRIVER =
	 * "com.microsoft.sqlserver.jdbc.SQLServerDriver"; private final String PASSWORD
	 * = "123456";
	 */

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:sqlserver://192.168.1.110:1433; databaseName = reservationproject ; encrypt=false;");
		driverManagerDataSource.setUsername("requestclient");
		driverManagerDataSource.setPassword("123456");
		driverManagerDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return driverManagerDataSource;
	}
	
}