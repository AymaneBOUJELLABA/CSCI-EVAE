package fr.ubo.dosi.CSCIEVAE.enstities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RUBRIQUE")
public class Rubrique implements Serializable {
    @Id
    @Column(name = "ID_RUBRIQUE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRubrique;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "NO_ENSEIGNANT")
    private Long noEnseignant;

    @Column(name = "DESIGNATION")
    private String designation;

    @Column(name = "ORDRE")
    private Long ordre;

    public Long getIdRubrique() {
        return this.idRubrique;
    }

    public void setIdRubrique(Long idRubrique) {
        this.idRubrique = idRubrique;
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

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getOrdre() {
        return this.ordre;
    }

    public void setOrdre(Long ordre) {
        this.ordre = ordre;
    }
}
