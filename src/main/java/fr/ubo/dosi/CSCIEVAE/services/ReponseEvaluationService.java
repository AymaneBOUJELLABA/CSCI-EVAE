package fr.ubo.dosi.CSCIEVAE.services;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.dto.EtudiantDTO;
import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseEvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Etudiant;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestion;

public interface ReponseEvaluationService 
{
	List<ReponseEvaluationDTO> getAllReponseEvaluations();

	List<ReponseEvaluationDTO> getAllReponseEvaluationsByUe(String codeUe,String anneeUniv);
	
	ReponseEvaluationDTO addReponseEvaluation(ReponseEvaluation entity);
	
	EvaluationDTO getEvaluationFromResponseEvaluation(Long idReponseEvaluation);
	
	Etudiant getEtudiantFromResponseEvaluation(Long idReponseEvaluation);
	
	List<ReponseQuestion> getAllQuestionReponseByIdReponseEvaluation(Long idReponseEvaluation); 
}
