package fr.ubo.dosi.CSCIEVAE.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ubo.dosi.CSCIEVAE.dto.QuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.enstities.Rubrique;
import fr.ubo.dosi.CSCIEVAE.messages.RubriqueOrdreUpdateMessage;
import fr.ubo.dosi.CSCIEVAE.repository.RubriqueRepository;
import fr.ubo.dosi.CSCIEVAE.utils.DataMapper;
@Service
public class RubriqueServiceImpl implements RubriqueService
{
	private static Logger logger = LogManager.getLogger(RubriqueServiceImpl.class);
	@Autowired
	RubriqueRepository rubriqueRepository;
	@Autowired
	EvaluationService evaluationService;
	
	
	private static DataMapper mapper = new DataMapper();

	@Override
	public List<RubriqueDTO> listdesRubriques() throws Exception
	{
		try
		{
			List<Rubrique> result = rubriqueRepository.findAllByOrderByOrdreAsc();
			List<RubriqueDTO> resultDTO = new ArrayList<RubriqueDTO>();
			
			for(Rubrique rub : result)
			{
				List<QuestionDTO> qs = evaluationService.getQuestionRubriqueForEvaluation(rub.getIdRubrique());
				RubriqueDTO rDTO = mapper.rubriqueMapperToDTO(rub, qs);
				
				resultDTO.add(rDTO);
			}
			return resultDTO;
			
		}catch(Exception e)
		{
			logger.error("Erreur list des Rubriques", e);
			throw new Exception("Exception List des Rubriques"+e);
		}
	}

	@Override
	public RubriqueDTO chercherRubriqueParId(Long id) throws Exception
	{
		try
		{
			Rubrique rub = rubriqueRepository.findById(id).get();
			List<QuestionDTO> qs = evaluationService.getQuestionRubriqueForEvaluation(rub.getIdRubrique());
			RubriqueDTO result = mapper.rubriqueMapperToDTO(rub,qs);
			return result;
		}catch(Exception e)
		{
			logger.error("Erreur chercher Rubrique Par ID", e);
			throw new Exception("Exception chercher Rubrique par Id"+e);
		}
	}

	@Override
	public RubriqueDTO ajouterRubrique(Rubrique entity) throws Exception
	{
		try
		{
			Rubrique rub = rubriqueRepository.findByDesignation(entity.getDesignation());
			if(rub!=null)
			{
				throw new Exception("Rubrique existe dèja!");
			}
			
			Rubrique newRub = rubriqueRepository.save(entity);
			return mapper.rubriqueMapperToDTO(newRub, null);
			
		}catch(Exception e)
		{
			logger.error("Erreur Ajouter Rubrique",e);
			throw new Exception("Erreur lors de l'ajout du rubrique"+e);
		}
	}

	
	
	//{ idRubrique , nouveauOrdre : }
	@Override
	public List<RubriqueDTO> modifierOrdreRubrique(List<RubriqueOrdreUpdateMessage> list) throws Exception
	{
		try
		{
			List<RubriqueDTO> result = new ArrayList<RubriqueDTO>();
			
			for(RubriqueOrdreUpdateMessage item : list)
			{
				
				if(rubriqueRepository.findById(item.getIdRubrique()).isEmpty())
				{
					logger.error("ID " + item.getIdRubrique() +" N'existe pas dans la table rubrique!!");
					throw new Exception("ID " + item.getIdRubrique() +" N'existe pas dans la table rubrique!!");
				}
				else
				{
					Rubrique r = rubriqueRepository.findById(item.getIdRubrique()).get();
					//modifier l'ordre
					r.setOrdre(item.getOrdre());
					//sauvegarder les modifications
					Rubrique newR = rubriqueRepository.save(r);
					//ajouter la nouvelle rubrique dans le resultat du sortie
					result.add(mapper.rubriqueMapperToDTO(newR, 
								evaluationService.getQuestionRubriqueForEvaluation(item.getIdRubrique())));
				}
			}
			return result;
			
		}catch(Exception e)
		{
			logger.error("Erreur Modifier Ordre Rubrique");
			throw new Exception("Erreur Modifier Ordre Rubrique"+ e);
		}		
	}

	@Override
	public Long chercherMaxOrdre()
	{
		return rubriqueRepository.findMaxOrdre();
	}
	
	

}
