package fr.ubo.dosi.CSCIEVAE.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "REPONSE_QUESTION")
@IdClass(ReponseQuestionId.class)
@AllArgsConstructor @NoArgsConstructor
public class ReponseQuestion implements Serializable {
    @Id
    @Column(name = "ID_REPONSE_EVALUATION")
    private Long idReponseEvaluation;

    @Id
    @Column(name = "ID_QUESTION_EVALUATION")
    private Long idQuestionEvaluation;

    @Column(name = "POSITIONNEMENT")
    private Long positionnement;

    public Long getIdReponseEvaluation() {
        return this.idReponseEvaluation;
    }

    public void setIdReponseEvaluation(Long idReponseEvaluation) {
        this.idReponseEvaluation = idReponseEvaluation;
    }

    public Long getIdQuestionEvaluation() {
        return this.idQuestionEvaluation;
    }

    public void setIdQuestionEvaluation(Long idQuestionEvaluation) {
        this.idQuestionEvaluation = idQuestionEvaluation;
    }

    public Long getPositionnement() {
        return this.positionnement;
    }

    public void setPositionnement(Long positionnement) {
        this.positionnement = positionnement;
    }
}
