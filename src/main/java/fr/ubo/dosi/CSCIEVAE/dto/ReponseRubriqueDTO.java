package fr.ubo.dosi.CSCIEVAE.dto;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.entity.Rubrique;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data @ToString
@EqualsAndHashCode
public class ReponseRubriqueDTO
{
	private Long idRubriqueEvaluation;
	private Rubrique rubriqueinfo;
	private List<ReponseQuestionDTO> questions;
}
