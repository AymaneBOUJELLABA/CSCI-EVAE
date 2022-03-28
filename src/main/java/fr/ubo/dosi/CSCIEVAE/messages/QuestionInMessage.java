package fr.ubo.dosi.CSCIEVAE.messages;

import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import lombok.Data;

@Data
class QuestionInMessage
{
	Long idQuestion;
	String intitule;
	String noEnseignant;
	Long order;
	Qualificatif qualificatif;
	Long reponse;
	Long type;
}