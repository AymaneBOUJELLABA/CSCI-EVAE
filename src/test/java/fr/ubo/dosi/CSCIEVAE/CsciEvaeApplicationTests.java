package fr.ubo.dosi.CSCIEVAE;

import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import fr.ubo.dosi.CSCIEVAE.services.EvaluationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
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

		
		

}
