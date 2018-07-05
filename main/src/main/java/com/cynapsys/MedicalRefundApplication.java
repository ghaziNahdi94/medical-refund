package com.cynapsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages= {"com.cynapsys"})
@ComponentScan(basePackages= {"com.cynapsys"})
@EntityScan(basePackages= {"com.cynapsys"})
public class MedicalRefundApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalRefundApplication.class, args);
	}
}
