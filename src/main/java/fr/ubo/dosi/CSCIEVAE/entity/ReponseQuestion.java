package fr.ubo.dosi.CSCIEVAE.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "REPONSE_QUESTION")
@IdClass(ReponseQuestionId.class)
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter

@ToString

public class ReponseQuestion implements Serializable {
    @Id
    @Column(name = "ID_REPONSE_EVALUATION")
    private Long idReponseEvaluation;

    @Id
    @Column(name = "ID_QUESTION_EVALUATION")
    private Long idQuestionEvaluation;

    @Column(name = "POSITIONNEMENT")
    private Long positionnement;

   
}
