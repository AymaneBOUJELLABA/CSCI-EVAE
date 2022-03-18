package fr.ubo.dosi.CSCIEVAE;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import fr.ubo.dosi.CSCIEVAE.entity.Rubrique;
import fr.ubo.dosi.CSCIEVAE.services.EvaluationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluationServiceTest {
	@Autowired
	private EvaluationService evaluationService;
  
	
	@Test
	public void getEvationByCodeUETest()
			  throws Exception {
		Evaluation eva= evaluationService.getEvalutionParCodeUe("ISI");
		assertEquals("M2DOSI",eva.getCodeFormation());
		assertEquals("2014-2015",eva.getAnneeUniversitaire());
		assertEquals("Evaluation ISI",eva.getDesignation());
		assertEquals("Du 22 septembre au 24 octobre",eva.getPeriode());		
	}
			
		@Test
		public void getAllRubriquesForEvaluationCreationTest()
				  throws Exception {
			List<Rubrique> rubriques = this.evaluationService.getRubriquesForEvaluationCreation(); ;		     
			assertEquals(8,rubriques.size());
			//verifier que les rubriques sont retournés dans l'ordre
			assertEquals(1,rubriques.get(0));
			assertEquals(2,rubriques.get(1));
			assertEquals(3,rubriques.get(2));
			assertEquals(4,rubriques.get(3));
			assertEquals(5,rubriques.get(4));
			assertEquals(6,rubriques.get(5));
			assertEquals(7,rubriques.get(6));
			assertEquals(8,rubriques.get(7));			
		}
		

		  

	}


