package fr.ubo.dosi.CSCIEVAE.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseQuestionId implements Serializable {

    private Long idReponseEvaluation;
    private Long idQuestionEvaluation;
}
