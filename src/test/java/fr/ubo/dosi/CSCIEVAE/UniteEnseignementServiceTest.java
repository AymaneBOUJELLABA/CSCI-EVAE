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

import fr.ubo.dosi.CSCIEVAE.service.UniteEnseignementService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UniteEnseignementServiceTest {
	
	@Autowired
	private UniteEnseignementService uniteEnseignementService;
  
	private List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	
	@Test
	public void ListUeByCodeFormation()
			  throws Exception {
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("codeUe","ISI");
		map1.put("designation","Ingénierie des Systèmes d'Information");
		map1.put("nom", "S");
		map1.put("prenom","P");
		this.list.add(map1);
		
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("codeUe","IDL");
		map2.put("designation","Ingénierie de Développement Logiciel");
		map2.put("nom", "S");
		map2.put("prenom","P");
		this.list.add(map2);
		
		Map<String,String> map3 = new HashMap<String,String>();
		map3.put("codeUe","J2EE");
		map3.put("designation","Java/J2EE");
		map3.put("nom", "LL");
		map3.put("prenom","MM");
		this.list.add(map3);
	
		Map<String,String> map4 = new HashMap<String,String>();
		map4.put("codeUe","SR");
		map4.put("designation","Systèmes Répartis");
		map4.put("nom", "LL");
		map4.put("prenom","MM");
		this.list.add(map4);
			
		Map<String,String> map5 = new HashMap<String,String>();
		map5.put("codeUe","EDE");
		map5.put("designation","Environnement de Développement");
		map5.put("nom", "Jean");
		map5.put("prenom","Patrick");
		this.list.add(map5);
		
		Map<String,String> map6 = new HashMap<String,String>();
		map6.put("codeUe","WEB");
		map6.put("designation","Langages du WEB");
		map6.put("nom", "Jean");
		map6.put("prenom","Patrick");
		this.list.add(map6);

		
		Map<String,String> map7 = new HashMap<String,String>();
		map7.put("codeUe","CO");
		map7.put("designation","Conception Objet");
		map7.put("nom", "KER");
		map7.put("prenom","Pat");
		this.list.add(map7);
		
		Map<String,String> map8 = new HashMap<String,String>();
		map8.put("codeUe","PCO");
		map8.put("designation","Préparation au Contexte de l'Offshore");
		map8.put("nom", "S");
		map8.put("prenom","P");
		this.list.add(map8);	
		
		List<Map<String,String>> ues= uniteEnseignementService.ListByCodeFormation("M2DOSI");
		assertEquals(8,ues.size());						
	}

	
	@Test
	public void DetailUe()
			  throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("nbhCm", "20");
		map.put("codeUe","WEB");
		map.put("mobile","06.00.00.89.28");
		map.put("nbhTp", "20");
		map.put("prenomEnseignant","Patrick");
		map.put("nomEnseigant","Jean");
		map.put("typeEnseignant","PRAST");
		map.put("nbhTd","20");
		map.put("emailUbo","gg@univ-brest.fr");
		map.put("designation","Langages du WEB");
		map.put("semestre","9  ");
		map.put("emailPerso",null);
		map.put("emailPerso",null);
		
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
