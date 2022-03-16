package fr.ubo.dosi.CSCIEVAE.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ELEMENT_CONSTITUTIF")
public class ElementConstitutif implements Serializable {
    @Id
    @Column(name = "CODE_FORMATION")
    private String codeFormation;

    @Id
    @Column(name = "CODE_UE")
    private String codeUe;

    @Id
    @Column(name = "CODE_EC")
    private String codeEc;

    @Column(name = "NO_ENSEIGNANT")
    private Long noEnseignant;

    @Column(name = "DESIGNATION")
    private String designation;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NBH_CM")
    private Long nbhCm;

    @Column(name = "NBH_TD")
    private Long nbhTd;

    @Column(name = "NBH_TP")
    private Long nbhTp;

    public String getCodeFormation() {
        return this.codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getCodeUe() {
        return this.codeUe;
    }

    public void setCodeUe(String codeUe) {
        this.codeUe = codeUe;
    }

    public String getCodeEc() {
        return this.codeEc;
    }

    public void setCodeEc(String codeEc) {
        this.codeEc = codeEc;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNbhCm() {
        return this.nbhCm;
    }

    public void setNbhCm(Long nbhCm) {
        this.nbhCm = nbhCm;
    }

    public Long getNbhTd() {
        return this.nbhTd;
    }

    public void setNbhTd(Long nbhTd) {
        this.nbhTd = nbhTd;
    }

    public Long getNbhTp() {
        return this.nbhTp;
    }

    public void setNbhTp(Long nbhTp) {
        this.nbhTp = nbhTp;
    }
}
