package fr.ubo.dosi.CSCIEVAE.services;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.enstities.Rubrique;

public interface RubriqueService
{
	public List<RubriqueDTO> listdesRubriques() throws Exception;
	
	public RubriqueDTO chercherRubriqueParId(Long id) throws Exception;
	
	public RubriqueDTO ajouterRubrique(Rubrique entity);
	
	public List<RubriqueDTO> modifierOrdreRubrique(List<Rubrique> list);
	
}
