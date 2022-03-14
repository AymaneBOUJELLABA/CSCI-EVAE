package fr.ubo.dosi.CSCIEVAE.services;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.enstities.Rubrique;
import fr.ubo.dosi.CSCIEVAE.messages.RubriqueOrdreUpdateMessage;

public interface RubriqueService
{
	public List<RubriqueDTO> listdesRubriques() throws Exception;
	
	public RubriqueDTO chercherRubriqueParId(Long id) throws Exception;
	
	public RubriqueDTO ajouterRubrique(Rubrique entity) throws Exception;
	
	public List<RubriqueDTO> modifierOrdreRubrique(List<RubriqueOrdreUpdateMessage> list) throws Exception;
	
}
