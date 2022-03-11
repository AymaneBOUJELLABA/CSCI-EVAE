package fr.ubo.dosi.CSCIEVAE.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ubo.dosi.CSCIEVAE.enstities.Rubrique;
import fr.ubo.dosi.CSCIEVAE.repository.RubriqueRepository;

@Service
public class RubriqueServiceImpl implements RubriqueService
{
	@Autowired
	RubriqueRepository rubriqueRepository;
	
	
	@Override
	public List<Rubrique> listdesRubriques()
	{
		return rubriqueRepository.findAll();
	}

	@Override
	public Rubrique chercherRubriqueParId(Long id)
	{
		return rubriqueRepository.getById(id);
	}

	@Override
	public Rubrique ajouterRubrique(Rubrique entity)
	{
		return rubriqueRepository.save(entity);
	}

	@Override
	public List<Rubrique> ajouterAllRubriques(List<Rubrique> list)
	{
		return rubriqueRepository.saveAll(list);
	}

}
