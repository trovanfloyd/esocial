package com.seplag.esocial.extrator;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class ExtratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtratorApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://172.25.4.135:5432/backup_producao_2");
		dataSource.setUsername("owfolha");
		dataSource.setPassword("owfolha");

		return dataSource;
	}
}
