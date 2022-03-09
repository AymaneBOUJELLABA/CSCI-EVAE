package fr.ubo.dosi.CSCIEVAE;

import fr.ubo.dosi.CSCIEVAE.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsciEvaeApplication implements CommandLineRunner {

	@Autowired
	private EnseignantRepository enseignantRepository;

	public static void main(String[] args) {
		SpringApplication.run(CsciEvaeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		enseignantRepository.findAll().forEach(
				e -> {
					System.out.println("Nom enseignant : "+e.getNom());
					System.out.println("Prenom enseignant : "+e.getPrenom());
					System.out.println("Email enseignant : "+e.getEmailUbo());
					System.out.println("Telephone enseignant : "+e.getMobile());
				}
		);

	}
}
