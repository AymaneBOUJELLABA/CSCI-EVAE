package fr.ubo.dosi.CSCIEVAE.dto;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class StatRubriqueDTO {
	
	private Long idRubrique;
    private String type;
    private String designation;
    private Long ordre;
    private List<StatReponseQuestionDTO> questions;

}
