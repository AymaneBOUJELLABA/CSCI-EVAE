package fr.ubo.dosi.CSCIEVAE.dto;


import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class StatReponseQuestionDTO {
	    private Long idQuestionEvaluation;
	    private Long idQuestion;
	    private String type;
	    private String intitule;
	    private Long order;
	    private Qualificatif qualificatif;
	    private Integer nbrPos1; 
	    private Integer nbrPos2;
	    private Integer nbrPos3;
	    private Integer nbrPos4;
	    private Integer nbrPos5;
	    private Integer max;
	    private Long moyenne;
}
