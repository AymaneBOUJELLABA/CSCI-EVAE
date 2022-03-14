package fr.ubo.dosi.CSCIEVAE.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DROIT")
@IdClass(DroitId.class)
public class Droit implements Serializable {
    @Id
    @Column(name = "ID_EVALUATION")
    private Long idEvaluation;

    @Id
    @Column(name = "NO_ENSEIGNANT")
    private Long noEnseignant;

    @Column(name = "CONSULTATION", columnDefinition = "CHAR")
    private String consultation;

    @Column(name = "DUPLICATION", columnDefinition = "CHAR")
    private String duplication;

    public Long getIdEvaluation() {
        return this.idEvaluation;
    }

    public void setIdEvaluation(Long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Long getNoEnseignant() {
        return this.noEnseignant;
    }

    public void setNoEnseignant(Long noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public String getConsultation() {
        return this.consultation;
    }

    public void setConsultation(String consultation) {
        this.consultation = consultation;
    }

    public String getDuplication() {
        return this.duplication;
    }

    public void setDuplication(String duplication) {
        this.duplication = duplication;
    }
}