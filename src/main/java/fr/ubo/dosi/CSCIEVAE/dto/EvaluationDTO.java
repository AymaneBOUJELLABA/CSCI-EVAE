package fr.ubo.dosi.CSCIEVAE.dto;

import lombok.Data;

import java.util.List;

@Data
public class EvaluationDTO {

    private Long idEvaluation;
    private Long noEnseignant;
    private Long noEvaluation;
    private String codeFormation;
    private String codeUe;
    private String codeEc;
    private String anneeUniversitaire;
    private String designation;
    private String etat;
    private String periode;
    private java.sql.Date debutReponse;
    private java.sql.Date finReponse;
    private List<RubriqueDTO> rubriques;
	

}
