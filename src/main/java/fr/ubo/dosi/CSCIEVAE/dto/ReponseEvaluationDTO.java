package fr.ubo.dosi.CSCIEVAE.dto;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.entity.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReponseEvaluationDTO
{
	private Long idReponseEvaluation;
	private EvaluationDTO evaluation;
	private Etudiant etudiant;
	private List<ReponseRubriqueDTO> rubriques;
}
