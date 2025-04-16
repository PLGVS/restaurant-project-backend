package com.plgvs.reservas_restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.plgvs.reservas_restaurante.entities")


@EnableJpaRepositories(basePackages = {
		"com.plgvs.reservas_restaurante.repositories",
		"com.plgvs.reservas_restaurante.services"
})
public class ReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}

}
