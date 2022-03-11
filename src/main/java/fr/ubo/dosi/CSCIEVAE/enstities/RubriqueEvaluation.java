package fr.ubo.dosi.CSCIEVAE.enstities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RUBRIQUE_EVALUATION")
public class RubriqueEvaluation implements Serializable {
    @Id
    @Column(name = "ID_RUBRIQUE_EVALUATION")
    private Long idRubriqueEvaluation;

    @Column(name = "ID_EVALUATION")
    private Long idEvaluation;

    @Column(name = "ID_RUBRIQUE")
    private Long idRubrique;

    @Column(name = "ORDRE")
    private Long ordre;

    @Column(name = "DESIGNATION")
    private String designation;

    public Long getIdRubriqueEvaluation() {
        return this.idRubriqueEvaluation;
    }

    public void setIdRubriqueEvaluation(Long idRubriqueEvaluation) {
        this.idRubriqueEvaluation = idRubriqueEvaluation;
    }

    public Long getIdEvaluation() {
        return this.idEvaluation;
    }

    public void setIdEvaluation(Long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Long getIdRubrique() {
        return this.idRubrique;
    }

    public void setIdRubrique(Long idRubrique) {
        this.idRubrique = idRubrique;
    }

    public Long getOrdre() {
        return this.ordre;
    }

    public void setOrdre(Long ordre) {
        this.ordre = ordre;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
