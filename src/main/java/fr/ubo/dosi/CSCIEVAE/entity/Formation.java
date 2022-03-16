package fr.ubo.dosi.CSCIEVAE.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FORMATION")
public class Formation implements Serializable {
    @Id
    @Column(name = "CODE_FORMATION")
    private String codeFormation;

    @Column(name = "DIPLOME")
    private String diplome;

    @Column(name = "N0_ANNEE")
    private Long n0Annee;

    @Column(name = "NOM_FORMATION")
    private String nomFormation;

    @Column(name = "DOUBLE_DIPLOME", columnDefinition = "CHAR")
    private String doubleDiplome;

    @Column(name = "DEBUT_ACCREDITATION")
    private java.sql.Date debutAccreditation;

    @Column(name = "FIN_ACCREDITATION")
    private java.sql.Date finAccreditation;

    public String getCodeFormation() {
        return this.codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getDiplome() {
        return this.diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Long getN0Annee() {
        return this.n0Annee;
    }

    public void setN0Annee(Long n0Annee) {
        this.n0Annee = n0Annee;
    }

    public String getNomFormation() {
        return this.nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public String getDoubleDiplome() {
        return this.doubleDiplome;
    }

    public void setDoubleDiplome(String doubleDiplome) {
        this.doubleDiplome = doubleDiplome;
    }

    public java.sql.Date getDebutAccreditation() {
        return this.debutAccreditation;
    }

    public void setDebutAccreditation(java.sql.Date debutAccreditation) {
        this.debutAccreditation = debutAccreditation;
    }

    public java.sql.Date getFinAccreditation() {
        return this.finAccreditation;
    }

    public void setFinAccreditation(java.sql.Date finAccreditation) {
        this.finAccreditation = finAccreditation;
    }
}
