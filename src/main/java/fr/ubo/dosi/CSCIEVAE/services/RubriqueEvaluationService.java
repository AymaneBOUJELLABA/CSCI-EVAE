package fr.ubo.dosi.CSCIEVAE.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ubo.dosi.CSCIEVAE.entity.RubriqueEvaluation;
import fr.ubo.dosi.CSCIEVAE.repository.RubriqueEvalutionRepository;

@Service
public class RubriqueEvaluationService {
	
	@Autowired
	private RubriqueEvalutionRepository rubriqueEvaluationRepository;
	
      public List<RubriqueEvaluation> findAllByIdEvaluationOrderByOrdreAsc(Long idEvaluation) {
		
		List<RubriqueEvaluation> rubriques = this.rubriqueEvaluationRepository.findAll();
		List<RubriqueEvaluation> rubriquesEvaluation = new ArrayList<RubriqueEvaluation>();
		List<RubriqueEvaluation> rubriquesEvaluationByOrdreAsc = new ArrayList<RubriqueEvaluation>();
		
		for(int i=0; i<rubriques.size(); i++) {
			
			if(rubriques.get(i).getIdEvaluation() == idEvaluation) {
				rubriquesEvaluation.add(rubriques.get(i));
				
			}			
		}
		
		
		//trier selon l'ordre
		while(rubriquesEvaluation.size()>0) {
		int i=0;
		RubriqueEvaluation min = rubriquesEvaluation.get(0);
		
		for(i=0;i<rubriquesEvaluation.size();i++) {
			if(min.getOrdre()> rubriquesEvaluation.get(i).getOrdre() )
				min= rubriquesEvaluation.get(i); 
		}
		
		//ajouter l'element à la liste triée
		rubriquesEvaluationByOrdreAsc.add(min);
		
		//supprimer l'élément de la liste non triée	
		rubriquesEvaluation.remove(min);
		
		}
		
		return rubriquesEvaluationByOrdreAsc;
		
	   }
		
		
		
	

}
