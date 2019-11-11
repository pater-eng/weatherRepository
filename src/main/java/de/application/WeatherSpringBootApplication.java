package de.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import de.application.controllers.WeatherController;
import de.application.services.WeatherService;

@SpringBootApplication(scanBasePackages = { "de.application.controllers", "de.application.services" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@ComponentScan(basePackageClasses = { WeatherController.class, WeatherService.class })
// @EnableFeignClients
public class WeatherSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherSpringBootApplication.class, args);
		System.out.println("START");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
