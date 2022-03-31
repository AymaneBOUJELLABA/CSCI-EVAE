package fr.ubo.dosi.CSCIEVAE;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.ubo.dosi.CSCIEVAE.dto.PromotionsStatsDTO;
import fr.ubo.dosi.CSCIEVAE.dto.QuestionReponseInfoDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseEvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseRubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Etudiant;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;
import fr.ubo.dosi.CSCIEVAE.repository.EtudiantRepository;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseEvaluationRepository;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseQuestionRepository;
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
	ReponseQuestionRepository reponseQuestionRepository;
	@Test void testGetQuestionReponseEval()
	{
		
		System.out.println("-------------- GETTING QUESTION RESPONSES OF EVALUATION");
		List<Object[]> r = reponseQuestionRepository.findAllReponseQuestionInfo((long) 1);
					
		r.forEach(item->
		{
			QuestionReponseInfoDTO i = QuestionReponseInfoDTO.builder()
						.idQuestion(((BigDecimal) item[0]).longValue())
						.type((String) item[1])
						.noEnseignant((String) item[2])
						.idQualificatif(((BigDecimal) item[3]).longValue())
						.intitule((String) item[4])
						.positionnement(((BigDecimal) item[5]).longValue())
						.noEtudiant(((String) item[6]))
						.idReponseEvaluation(((BigDecimal) item[7]).longValue())
						.idRubriqueEvaluation(((BigDecimal) item[8]).longValue())
						.build();
		});
	}

	@Test void testgetAllreponseevaluation()
	{
		System.out.println("________ GETTING ALL REPONSE EVALUATIONS");
		List<ReponseEvaluationDTO> r = reponseEvaluationService.getAllReponseEvaluations();
		
		
		r.forEach(rub ->
		{
			System.out.println("etd => "+rub.getEtudiant());
			System.out.println("eval => "+rub.getEvaluation());
			
			for(ReponseRubriqueDTO i : rub.getRubriques())
			{
				System.out.println("\t - rub info => "+i.getRubriqueinfo());
				System.out.println("\t - id rub eval => "+i.getIdRubriqueEvaluation());
				
				i.getQuestions().forEach(q -> {
					System.out.println("\t\t - question info => "+q.getQuestion());
					System.out.println("\t\t - question pos => "+q.getPositionnement());
				});
			}
		});
	}
	

}
