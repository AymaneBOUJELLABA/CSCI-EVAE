package fr.ubo.dosi.CSCIEVAE.dto;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.entity.Etudiant;
import lombok.Data;

@Data
public class ReponseEvaluationDTO
{
	private Long idReponseEvaluation;
	private EvaluationDTO evaluation;
	private Etudiant etudiant;
	private String commentaire;
	private List<ReponseRubriqueDTO> rubriques;
	
	
	
	@Override
	public String toString()
	{
		String msg = "";
		msg +="\netd => "+this.getEtudiant();
		msg +="\neval => "+this.getEvaluation();
		msg +="\ncommentaire => "+this.getCommentaire();
		
		for(ReponseRubriqueDTO i : this.getRubriques())
		{
			msg +="\n\t - rub info => "+i.getRubriqueinfo();
			msg +="\n\t - id rub eval => "+i.getIdRubriqueEvaluation();
			
			for(ReponseQuestionDTO q : i.getQuestions())
			{
				msg +="\n\t\t - question info => "+q.getQuestion();
				msg +="\n\t\t - question pos => "+q.getPositionnement();
			};
		}
		
		return msg;
	}
}
