<<<<<<< HEAD:src/main/java/fr/ubo/dosi/CSCIEVAE/enstities/Promotion.java
package fr.ubo.dosi.CSCIEVAE.enstities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PROMOTION")
public class Promotion implements Serializable {
    @Id
    @Column(name = "CODE_FORMATION")
    private String codeFormation;

    @Id
    @Column(name = "ANNEE_UNIVERSITAIRE")
    private String anneeUniversitaire;

    @Column(name = "NO_ENSEIGNANT")
    private Long noEnseignant;

    @Column(name = "SIGLE_PROMOTION")
    private String siglePromotion;

    @Column(name = "NB_MAX_ETUDIANT")
    private Long nbMaxEtudiant;

    @Column(name = "DATE_REPONSE_LP")
    private java.sql.Date dateReponseLp;

    @Column(name = "DATE_REPONSE_LALP")
    private java.sql.Date dateReponseLalp;

    @Column(name = "DATE_RENTREE")
    private java.sql.Date dateRentree;

    @Column(name = "LIEU_RENTREE")
    private String lieuRentree;

    @Column(name = "PROCESSUS_STAGE")
    private String processusStage;

    @Column(name = "COMMENTAIRE")
    private String commentaire;

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

    public Long getNoEnseignant() {
        return this.noEnseignant;
    }

    public void setNoEnseignant(Long noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public String getSiglePromotion() {
        return this.siglePromotion;
    }

    public void setSiglePromotion(String siglePromotion) {
        this.siglePromotion = siglePromotion;
    }

    public Long getNbMaxEtudiant() {
        return this.nbMaxEtudiant;
    }

    public void setNbMaxEtudiant(Long nbMaxEtudiant) {
        this.nbMaxEtudiant = nbMaxEtudiant;
    }

    public java.sql.Date getDateReponseLp() {
        return this.dateReponseLp;
    }

    public void setDateReponseLp(java.sql.Date dateReponseLp) {
        this.dateReponseLp = dateReponseLp;
    }

    public java.sql.Date getDateReponseLalp() {
        return this.dateReponseLalp;
    }

    public void setDateReponseLalp(java.sql.Date dateReponseLalp) {
        this.dateReponseLalp = dateReponseLalp;
    }

    public java.sql.Date getDateRentree() {
        return this.dateRentree;
    }

    public void setDateRentree(java.sql.Date dateRentree) {
        this.dateRentree = dateRentree;
    }

    public String getLieuRentree() {
        return this.lieuRentree;
    }

    public void setLieuRentree(String lieuRentree) {
        this.lieuRentree = lieuRentree;
    }

    public String getProcessusStage() {
        return this.processusStage;
    }

    public void setProcessusStage(String processusStage) {
        this.processusStage = processusStage;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
=======
package fr.ubo.dosi.CSCIEVAE.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PROMOTION")
@IdClass(PromotionId.class)
public class Promotion implements Serializable {
    @Id
    @Column(name = "CODE_FORMATION")
    private String codeFormation;

    @Id
    @Column(name = "ANNEE_UNIVERSITAIRE")
    private String anneeUniversitaire;

    @Column(name = "NO_ENSEIGNANT")
    private Long noEnseignant;

    @Column(name = "SIGLE_PROMOTION")
    private String siglePromotion;

    @Column(name = "NB_MAX_ETUDIANT")
    private Long nbMaxEtudiant;

    @Column(name = "DATE_REPONSE_LP")
    private java.sql.Date dateReponseLp;

    @Column(name = "DATE_REPONSE_LALP")
    private java.sql.Date dateReponseLalp;

    @Column(name = "DATE_RENTREE")
    private java.sql.Date dateRentree;

    @Column(name = "LIEU_RENTREE")
    private String lieuRentree;

    @Column(name = "PROCESSUS_STAGE")
    private String processusStage;

    @Column(name = "COMMENTAIRE")
    private String commentaire;

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

    public Long getNoEnseignant() {
        return this.noEnseignant;
    }

    public void setNoEnseignant(Long noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public String getSiglePromotion() {
        return this.siglePromotion;
    }

    public void setSiglePromotion(String siglePromotion) {
        this.siglePromotion = siglePromotion;
    }

    public Long getNbMaxEtudiant() {
        return this.nbMaxEtudiant;
    }

    public void setNbMaxEtudiant(Long nbMaxEtudiant) {
        this.nbMaxEtudiant = nbMaxEtudiant;
    }

    public java.sql.Date getDateReponseLp() {
        return this.dateReponseLp;
    }

    public void setDateReponseLp(java.sql.Date dateReponseLp) {
        this.dateReponseLp = dateReponseLp;
    }

    public java.sql.Date getDateReponseLalp() {
        return this.dateReponseLalp;
    }

    public void setDateReponseLalp(java.sql.Date dateReponseLalp) {
        this.dateReponseLalp = dateReponseLalp;
    }

    public java.sql.Date getDateRentree() {
        return this.dateRentree;
    }

    public void setDateRentree(java.sql.Date dateRentree) {
        this.dateRentree = dateRentree;
    }

    public String getLieuRentree() {
        return this.lieuRentree;
    }

    public void setLieuRentree(String lieuRentree) {
        this.lieuRentree = lieuRentree;
    }

    public String getProcessusStage() {
        return this.processusStage;
    }

    public void setProcessusStage(String processusStage) {
        this.processusStage = processusStage;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
>>>>>>> master:src/main/java/fr/ubo/dosi/CSCIEVAE/entity/Promotion.java
