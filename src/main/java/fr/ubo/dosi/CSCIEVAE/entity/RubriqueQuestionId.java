package fr.ubo.dosi.CSCIEVAE.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubriqueQuestionId implements Serializable {

    private Long idRubrique;
    private Long idQuestion;

}
