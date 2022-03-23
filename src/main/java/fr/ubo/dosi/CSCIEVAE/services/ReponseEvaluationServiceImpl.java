package fr.ubo.dosi.CSCIEVAE.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseEvaluationRepository;

public class ReponseEvaluationServiceImpl implements ReponseEvaluationService
{
	
	@Autowired
	ReponseEvaluationRepository reponseEvalRepo;
	@Autowired
	EvaluationService evaluationService;

	@Override
	public List<ReponseEvaluation> getAllReponseEvaluations()
	{
		return reponseEvalRepo.findAll();
	}

	@Override
	public List<ReponseEvaluation> getAllReponseEvaluationsByUe(String codeUe,String anneeUniv)
	{
		Evaluation eval = evaluationService.getEvalutionParCodeUeAndAnneeUniv(codeUe,anneeUniv);
		
		return null;
	}

	@Override
	public ReponseEvaluation addReponseEvaluation(ReponseEvaluation entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
