package fr.ubo.dosi.CSCIEVAE.enstities;

import javax.persistence.*;

@Entity
@Table(name = "EVALUATION")
public class Evaluation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_EVALUATION")
    private Long idEvaluation;

    @Column(name = "NO_ENSEIGNANT")
    private Long noEnseignant;

    @Column(name = "CODE_FORMATION")
    private String codeFormation;

    @Column(name = "ANNEE_UNIVERSITAIRE")
    private String anneeUniversitaire;

    @Column(name = "CODE_UE")
    private String codeUe;

    @Column(name = "CODE_EC")
    private String codeEc;

    @Column(name = "NO_EVALUATION")
    private Long noEvaluation;

    @Column(name = "DESIGNATION")
    private String designation;

    @Column(name = "ETAT", columnDefinition = "CHAR")
    private String etat;

    @Column(name = "PERIODE")
    private String periode;

    @Column(name = "DEBUT_REPONSE")
    private java.sql.Date debutReponse;

    @Column(name = "FIN_REPONSE")
    private java.sql.Date finReponse;

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

    public String getCodeFormation() {
        return this.codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getAnneeUniversitaire() {
        return this.anneeUniversitaire;
    }

    public void setAnneeUniversitaire(String anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
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

    public Long getNoEvaluation() {
        return this.noEvaluation;
    }

    public void setNoEvaluation(Long noEvaluation) {
        this.noEvaluation = noEvaluation;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEtat() {
        return this.etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getPeriode() {
        return this.periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public java.sql.Date getDebutReponse() {
        return this.debutReponse;
    }

    public void setDebutReponse(java.sql.Date debutReponse) {
        this.debutReponse = debutReponse;
    }

    public java.sql.Date getFinReponse() {
        return this.finReponse;
    }

    public void setFinReponse(java.sql.Date finReponse) {
        this.finReponse = finReponse;
    }
}
