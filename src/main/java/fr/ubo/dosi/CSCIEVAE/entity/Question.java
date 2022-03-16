package fr.ubo.dosi.CSCIEVAE.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "QUESTION")
public class Question implements Serializable {
    @Id
    @Column(name = "ID_QUESTION")
    private Long idQuestion;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "NO_ENSEIGNANT")
    private Long noEnseignant;

    @Column(name = "ID_QUALIFICATIF")
    private Long idQualificatif;

    @Column(name = "INTITULE")
    private String intitule;

    public Long getIdQuestion() {
        return this.idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getNoEnseignant() {
        return this.noEnseignant;
    }

    public void setNoEnseignant(Long noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public Long getIdQualificatif() {
        return this.idQualificatif;
    }

    public void setIdQualificatif(Long idQualificatif) {
        this.idQualificatif = idQualificatif;
    }

    public String getIntitule() {
        return this.intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
