package fr.ubo.dosi.CSCIEVAE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ReponseQuestionDTO
{
	//La question dans l'evaluation
	private Long idQuestionEvaluation;
	//L'id de la reponse de l'evaluation
	private Long idReponseEvaluation;
	//réponse de l'étudiant
	private Long positionnement;
	
	private QuestionDTO question;
}
