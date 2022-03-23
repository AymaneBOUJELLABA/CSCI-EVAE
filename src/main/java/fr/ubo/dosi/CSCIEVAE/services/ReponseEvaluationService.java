package fr.ubo.dosi.CSCIEVAE.services;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;

public interface ReponseEvaluationService 
{
	List<ReponseEvaluation> getAllReponseEvaluations();

	List<ReponseEvaluation> getAllReponseEvaluationsByUe(String codeUe,String anneeUniv);
	
	ReponseEvaluation addReponseEvaluation(ReponseEvaluation entity);
}
