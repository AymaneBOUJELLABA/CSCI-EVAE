package fr.ubo.dosi.CSCIEVAE.messages;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor @NoArgsConstructor
@ToString
public class EvaluationReponseInMessage
{
	Long idEvaluation;
	String idEtudiant;
	String commentaire;
	List<RubriqueInMessage> rubriques;
}