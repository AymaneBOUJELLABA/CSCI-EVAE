package fr.ubo.dosi.CSCIEVAE;

import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.QuestionReponseInfoDTO;
import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestion;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseEvaluationRepository;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseQuestionRepository;
import fr.ubo.dosi.CSCIEVAE.services.EvaluationService;
import fr.ubo.dosi.CSCIEVAE.services.ReponseEvaluationService;
import fr.ubo.dosi.CSCIEVAE.services.RubriqueService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
class CsciEvaeApplicationTests {

	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private EvaluationService evaluationService;

	String ServerPort = "8082";
	final String baseUrl = "http://localhost:" + ServerPort + "/api";

	/* Tests Unitaires */
	@Test
	public void testFindEvaluations(){
		Assertions.assertFalse(evaluationService.getAllEvalutions().isEmpty());
	}


	/* Tests d'integrations */
		@Test
	public void testGetAllEvaluation() throws URISyntaxException {

		String localUrl = baseUrl+"/evaluations/ue";
		URI uri = new URI(localUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		//Verify request succeed
		Assertions.assertEquals(302, result.getStatusCodeValue());
		Assertions.assertFalse(Objects.requireNonNull(result.getBody()).isEmpty());

	}
		
		//public ResponseEntity<EvaluationDTO> getEvationByCodeUE(@RequestParam String codeUe)
		
		@Test
		public void getEvationByCodeUE()
				  throws Exception {
			String localUrl = baseUrl+"/evaluations/ue";
			URI uri = new URI(localUrl);			
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			System.out.println(result.getClass().getFields().length);
			//E eva= evaluationService.getEvalutionParCodeUe("ISI");
			//assertEquals(5,eva.getRubriques().size());						
		}
		
		
		@Autowired
		RubriqueService rubriqueService;
		@Test
		public void getAllRubrique()
		{
			List<RubriqueDTO> list = null;
			try {
				 list= rubriqueService.listdesRubriques();
				 for(RubriqueDTO r: list)
				 {
					 System.out.println(r);
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			Assertions.assertTrue(list != null);
		}
		
		
		@Autowired
		ReponseEvaluationRepository reponseEvaluationRepository;
		
		@Test void testGetAllReponseEvaluation()
		{
			List<ReponseEvaluation> r = reponseEvaluationRepository.findAllByCodeUeAndAnneUniv("ISI", "2014-2015");
			
			for(ReponseEvaluation i : r)
			{
				System.out.println(i);
			}
		}
		
		@Autowired
		ReponseQuestionRepository reponseQuestionRepository;
		@Test void testGetQuestionReponseEval()
		{
			
			System.out.println("-------------- GETTING QUESTION RESPONSES OF EVALUATION");
			List<Object[]> r = reponseQuestionRepository.findAllReponseQuestionInfo(1);
						
			r.forEach(item->
			{
				QuestionReponseInfoDTO i = QuestionReponseInfoDTO.builder()
							.idQuestion(((BigDecimal) item[0]).longValue())
							.type((String) item[1])
							.noEnseignant((String) item[2])
							.idQualificatif(((BigDecimal) item[3]).longValue())
							.intitule((String) item[4])
							.positionnement(((BigDecimal) item[5]).intValue())
							.noEtudiant(((String) item[6]))
							.idReponseEvaluation(((BigDecimal) item[7]).longValue())
							.idRubriqueEvaluation(((BigDecimal) item[8]).longValue())
							.build();
			});
		}

}
