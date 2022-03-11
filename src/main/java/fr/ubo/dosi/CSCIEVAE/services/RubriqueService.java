package fr.ubo.dosi.CSCIEVAE.services;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.enstities.Rubrique;

public interface RubriqueService
{
	public List<Rubrique> listdesRubriques();
	
	public Rubrique chercherRubriqueParId(Long id);
	
	public Rubrique ajouterRubrique(Rubrique entity);
	
	public List<Rubrique> ajouterAllRubriques(List<Rubrique> list);
	
}
