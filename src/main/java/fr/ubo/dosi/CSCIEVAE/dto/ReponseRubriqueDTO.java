package fr.ubo.dosi.CSCIEVAE.dto;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.entity.Rubrique;
import lombok.Data;
import lombok.ToString;

@Data @ToString
public class ReponseRubriqueDTO
{
	private Rubrique rubriqueinfo;
	private List<ReponseQuestionDTO> questions;
}
