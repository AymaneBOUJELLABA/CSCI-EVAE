package fr.ubo.dosi.CSCIEVAE.messages;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import lombok.Data;

@Data
public class EvaluationReponseInMessage
{
	Long idEvaluation;
	String idEtudiant;
	String commentaire;
	List<RubriqueInMessage> rubriques;
}