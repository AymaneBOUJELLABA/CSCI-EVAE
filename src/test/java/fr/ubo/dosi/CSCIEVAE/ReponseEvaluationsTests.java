package fr.ubo.dosi.CSCIEVAE;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.ubo.dosi.CSCIEVAE.dto.PromotionsStatsDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseEvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Etudiant;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;
import fr.ubo.dosi.CSCIEVAE.repository.EtudiantRepository;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseEvaluationRepository;
import fr.ubo.dosi.CSCIEVAE.services.ReponseEvaluationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReponseEvaluationsTests
{
	
	@Autowired
	ReponseEvaluationService reponseEvaluationService;
	@Test
	public void getAllPrmotionsGraphesData()
	{
		List<PromotionsStatsDTO> result = reponseEvaluationService.getAllPromotionsGraphesData();
		
		result.forEach(r -> {
			System.out.println("PROMO : " + r.getCodeFormation()  + " " + r.getAnneUniv());
			System.out.println("\t Réponses des evaluations du promo : ");
			r.getReponseEvaluations().forEach(repEval -> {
				System.out.println("\t\t repEval : "  + repEval.getCodeUe());
				repEval.getRubriques().forEach(rub->{
					System.out.println("\t\t\t Rubrique : " + rub.getDesignation() + " | moy = " + rub.getMoyenne());
				});
			});
		});
		
	}
	
	@Autowired
	ReponseEvaluationRepository reponseEvaluationRepository;
	@Test
	public void populateDTOfromReponseEval()
	{
		ReponseEvaluation repEval = reponseEvaluationRepository.findById(1L).get();
		
		ReponseEvaluationDTO result = reponseEvaluationService.populateDTOfromReponseEvaluation(repEval);
		
	}
	
	@Autowired
	EtudiantRepository etudiantRepository;
	@Test
	public void getEtudiantByNoEtudiant()
	{
		//Etudiant etd = etudiantRepository.findById("");
	}

}
