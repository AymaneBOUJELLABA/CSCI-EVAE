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
public class RubriqueDTO {

    private Long idRubrique;
    private String type;
    private String designation;
    private Long ordre;
    private List<QuestionDTO> questions;
  

}
