package fr.ubo.dosi.CSCIEVAE.services;

import java.util.List;
import java.util.NoSuchElementException;

import fr.ubo.dosi.CSCIEVAE.dto.QuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Rubrique;
import fr.ubo.dosi.CSCIEVAE.messages.RubriqueOrdreUpdateMessage;

public interface RubriqueService
{
	public List<RubriqueDTO> listdesRubriques() throws Exception;
	
	public RubriqueDTO chercherRubriqueParId(Long id) throws Exception;
	
	public RubriqueDTO ajouterRubrique(Rubrique entity) throws Exception;
	
	public List<RubriqueDTO> modifierOrdreRubrique(List<RubriqueOrdreUpdateMessage> list) throws Exception;
	
	public Long chercherMaxOrdre();
	
	public List<RubriqueDTO> ajouterOrUpdateAllRubriques(List<Rubrique> items) throws Exception;

	List<QuestionDTO> getQuestionsForRubrique(Long idRubrique);
	
	Rubrique getRubriqueByDesignation(String Designation) throws NoSuchElementException;

	Rubrique getRubriqueByIdRubriqueEvaluation(Long idRubriqueEvaluation) throws NoSuchElementException;
	
}
