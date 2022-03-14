package fr.ubo.dosi.CSCIEVAE;

import fr.ubo.dosi.CSCIEVAE.services.EvaluationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

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

	}

}
