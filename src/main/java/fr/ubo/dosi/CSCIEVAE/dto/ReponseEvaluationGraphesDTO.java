package fr.ubo.dosi.CSCIEVAE.dto;

import java.util.List;

import lombok.Data;

@Data
public class ReponseEvaluationGraphesDTO
{
	String CodeUe;
	List<RubriqueGraphesDTO> rubriques;
}
