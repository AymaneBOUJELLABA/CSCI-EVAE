package fr.ubo.dosi.CSCIEVAE.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data @ToString
public class QuestionReponseInfoDTO
{
	Long idQuestion;
	String type;
	String noEnseignant;
	Long idQualificatif;
	String intitule;
	Long positionnement;
	String noEtudiant;
	Long idReponseEvaluation;
	Long idRubriqueEvaluation;
	Long idQuestionEvaluation;
	Long ordre;
}
