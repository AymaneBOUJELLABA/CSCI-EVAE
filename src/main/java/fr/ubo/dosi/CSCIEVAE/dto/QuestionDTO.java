package fr.ubo.dosi.CSCIEVAE.dto;

import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class QuestionDTO {

    private Long idQuestion;
    private String type;
    private Long noEnseignant;
    private String intitule;
    private Long order;
    private Qualificatif qualificatif;
	
    
    

}
