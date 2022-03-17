package fr.ubo.dosi.CSCIEVAE;


import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.ubo.dosi.CSCIEVAE.services.UniteEnseignementService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UniteEnseignementServiceTest {
	
	@Autowired
	private UniteEnseignementService uniteEnseignementService;
  
	private List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	
	@Test
	public void ListUeByCodeFormation()
			  throws Exception {
		
		
		List<Map<String,String>> ues= uniteEnseignementService.ListByCodeFormation("M2DOSI");
		assertEquals(8,ues.size());						
	}

	
	@Test
	public void DetailUe()
			  throws Exception {
	
		
		Map<String,String> ue= uniteEnseignementService.getByCodeUe("WEB");
		assertEquals(13,ue.size());	
		
		assertEquals("20",ue.get("nbhCm"));
		assertEquals("WEB",ue.get("codeUe"));
		assertEquals("06.00.00.89.28",ue.get("mobile"));
		assertEquals("20",ue.get("nbhTp"));
		assertEquals("Patrick",ue.get("prenomEnseignant"));		
		assertEquals("Jean",ue.get("nomEnseigant"));
		assertEquals("PRAST",ue.get("typeEnseignant"));
		assertEquals("gg@univ-brest.fr",ue.get("emailUbo"));
		assertEquals("Langages du WEB",ue.get("designation"));		
		assertEquals("9  ",ue.get("semestre"));
		assertEquals(null,ue.get("emailPerso"));
		
	}

}
