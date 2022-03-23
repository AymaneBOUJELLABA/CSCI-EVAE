package fr.ubo.dosi.CSCIEVAE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ReponseQuestionDTO
{
	private Long idQuestionEvaluation;
	private RubriqueDTO rubrique;
	private QuestionDTO question;
	private Long position;
}
