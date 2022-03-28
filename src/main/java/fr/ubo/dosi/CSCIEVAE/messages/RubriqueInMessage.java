package fr.ubo.dosi.CSCIEVAE.messages;
import java.util.List;

import lombok.Data;

@Data
public class RubriqueInMessage 
{
	Long idRubrique;
	String designation;
	List<QuestionInMessage> questions;
}