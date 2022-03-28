package fr.ubo.dosi.CSCIEVAE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
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
