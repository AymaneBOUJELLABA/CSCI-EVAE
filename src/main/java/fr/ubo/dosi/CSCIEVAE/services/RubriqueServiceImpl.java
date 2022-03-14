package fr.ubo.dosi.CSCIEVAE.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ubo.dosi.CSCIEVAE.controllers.RubriqueController;
import fr.ubo.dosi.CSCIEVAE.dto.QuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.enstities.Rubrique;
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
			List<Rubrique> result = rubriqueRepository.findAllOrderByOrdreAsc();
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
	public RubriqueDTO ajouterRubrique(Rubrique entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RubriqueDTO> modifierOrdreRubrique(List<Rubrique> list) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
