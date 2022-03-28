package fr.ubo.dosi.CSCIEVAE.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "QUESTION_EVALUATION")
@AllArgsConstructor @NoArgsConstructor
public class QuestionEvaluation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_QUESTION_EVALUATION")
    private Long idQuestionEvaluation;

    @Column(name = "ID_RUBRIQUE_EVALUATION")
    private Long idRubriqueEvaluation;

    @Column(name = "ID_QUESTION")
    private Long idQuestion;

    @Column(name = "ID_QUALIFICATIF")
    private Long idQualificatif;

    @Column(name = "ORDRE")
    private Long ordre;

    @Column(name = "INTITULE")
    private String intitule;

    public Long getIdQuestionEvaluation() {
        return this.idQuestionEvaluation;
    }

    public void setIdQuestionEvaluation(Long idQuestionEvaluation) {
        this.idQuestionEvaluation = idQuestionEvaluation;
    }

    public Long getIdRubriqueEvaluation() {
        return this.idRubriqueEvaluation;
    }

    public void setIdRubriqueEvaluation(Long idRubriqueEvaluation) {
        this.idRubriqueEvaluation = idRubriqueEvaluation;
    }

    public Long getIdQuestion() {
        return this.idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Long getIdQualificatif() {
        return this.idQualificatif;
    }

    public void setIdQualificatif(Long idQualificatif) {
        this.idQualificatif = idQualificatif;
    }

    public Long getOrdre() {
        return this.ordre;
    }

    public void setOrdre(Long ordre) {
        this.ordre = ordre;
    }

    public String getIntitule() {
        return this.intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
