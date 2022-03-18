package fr.ubo.dosi.CSCIEVAE;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("fr.ubo.dosi.CSCIEVAE.entity") 
public class CsciEvaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsciEvaeApplication.class, args);
	}

}
