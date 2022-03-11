package fr.ubo.dosi.CSCIEVAE.dto;

import fr.ubo.dosi.CSCIEVAE.enstities.Qualificatif;
import lombok.Data;

@Data
public class QuestionDTO {

    private Long idQuestion;
    private String type;
    private Long noEnseignant;
    private String intitule;
    private Long order;
    private Qualificatif qualificatif;

}
