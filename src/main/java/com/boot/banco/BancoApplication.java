package com.boot.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan(basePackages = {"com/boot/banco/controllers", "com/boot/banco/daos", "com/boot/banco/services"})
@EntityScan(basePackages = {"com/boot/banco/models"})
@EnableJpaRepositories(basePackages = {"com/boot/banco/daos"})
public class BancoApplication {
	private static final Logger logger = LoggerFactory.getLogger(BancoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
		logger.info("SE INICIALIZO APLICATIVO POR EL PUERTO: 8080");
	}
}
