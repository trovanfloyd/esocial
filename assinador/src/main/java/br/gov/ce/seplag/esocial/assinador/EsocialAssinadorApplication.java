package br.gov.ce.seplag.esocial.assinador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@PropertySource("application-${env:dev}.properties")
@RequestMapping("api/esocial/assinador")
public class EsocialAssinadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsocialAssinadorApplication.class, args);
	}
}
