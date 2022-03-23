package fr.ubo.dosi.CSCIEVAE.dto;

import java.util.List;

import lombok.Data;

@Data
public class ReponseEvaluationDTO
{
	private EvaluationDTO evaluation;
	private EtudiantDTO etudiant;
	private List<ReponseQuestionDTO> questions;
}
