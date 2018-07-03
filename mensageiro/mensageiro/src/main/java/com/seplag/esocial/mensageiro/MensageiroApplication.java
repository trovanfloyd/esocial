package com.seplag.esocial.mensageiro;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class MensageiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensageiroApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {

		System.getProperties().setProperty("http.proxySet", "true");
		System.getProperties().setProperty("http.proxyHost", "172.25.4.1");
		System.getProperties().setProperty("http.proxyPort", "3128");
		System.getProperties().setProperty("https.proxyHost", "172.25.4.1");
		System.getProperties().setProperty("https.proxyPort", "3128");
		System.getProperties().setProperty("http.proxyUser", "fernando.freitas");
		System.getProperties().setProperty("http.proxyPassword", "Vancouver24!$");

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://172.25.4.135:5432/backup_producao_2");
		dataSource.setUsername("owfolha");
		dataSource.setPassword("owfolha");

		return dataSource;
	}

}
