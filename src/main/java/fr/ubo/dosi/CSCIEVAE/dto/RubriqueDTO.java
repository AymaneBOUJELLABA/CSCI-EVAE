package fr.ubo.dosi.CSCIEVAE.dto;

import lombok.Data;

import java.util.List;

@Data
public class RubriqueDTO {

    private Long idRubrique;
    private String type;
    private String designation;
    private Long ordre;
    private List<QuestionDTO> questions;

}
