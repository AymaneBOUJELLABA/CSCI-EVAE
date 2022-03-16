package fr.ubo.dosi.CSCIEVAE;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("fr.ubo.dosi.CSCIEVAE.entity") 
public class CsciEvaeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CsciEvaeApplication.class, args);
	}

	@Override
	public void run(String... args){

	}
}
