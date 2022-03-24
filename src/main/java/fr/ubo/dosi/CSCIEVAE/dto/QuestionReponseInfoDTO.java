package fr.ubo.dosi.CSCIEVAE.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QuestionReponseInfoDTO
{
	private Long idQuestion;
	private String type;
	private Long noEnseignant;
	private Long ID_QUALIFICATIF;
	private String intitule;
	private Long positionnement;
	private Long noEtudiant;
	private Long idReponseEvaluation;
	private Long idRubriqueEvaluation;

}
