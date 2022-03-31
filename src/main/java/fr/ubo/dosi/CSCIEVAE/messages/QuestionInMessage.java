package fr.ubo.dosi.CSCIEVAE.messages;

import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor @NoArgsConstructor
@ToString
public class QuestionInMessage
{
	Long idQuestion;
	String intitule;
	Long noEnseignant;
	Long order;
	Qualificatif qualificatif;
	Long reponse;
	String type;
}