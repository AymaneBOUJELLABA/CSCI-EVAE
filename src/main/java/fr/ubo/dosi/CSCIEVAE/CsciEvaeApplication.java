package fr.ubo.dosi.CSCIEVAE;

import fr.ubo.dosi.CSCIEVAE.repository.EnseignantRepository;
import fr.ubo.dosi.CSCIEVAE.services.EvaluationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsciEvaeApplication implements CommandLineRunner {

	@Autowired
	private EnseignantRepository enseignantRepository;

	@Autowired
	private EvaluationService evaluationService;
	
	public static void main(String[] args) {
		SpringApplication.run(CsciEvaeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*enseignantRepository.findAll().forEach(
				e -> {
					System.out.println("Nom enseignant : "+e.getNom());
					System.out.println("Prenom enseignant : "+e.getPrenom());
					System.out.println("Email enseignant : "+e.getEmailUbo());
					System.out.println("Telephone enseignant : "+e.getMobile());
				}
		);*/
		
		
		/*Gson gson = new Gson();
		evaluationService.getRubriqueEvaluation((long) 1).forEach(
				(r) -> {

					String evaluationJson = gson.toJson(r);
					System.out.println(evaluationJson);
					*//*
					System.out.println("=> Rubrique : "+ r.getDesignation());
					r.getQuestions()
							.forEach(question -> {
								System.out.println("	--> Question "+ question.getOrder()+" : "
										+question.getIntitule() + " | Min : "+question.getQualificatif().getMinimal()
										+" / Max : "+question.getQualificatif().getMaximal());
							});*//*
				}
		);*/

		/*
		enseignantRepository.findAll().forEach(
				e -> {
					System.out.println("Nom enseignant : "+e.getNom());
					System.out.println("Prenom enseignant : "+e.getPrenom());
					System.out.println("Email enseignant : "+e.getEmailUbo());
					System.out.println("Telephone enseignant : "+e.getMobile());
				}
		);
		*/

	}
}
