package fr.ubo.dosi.CSCIEVAE.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "REPONSE_EVALUATION")
@ToString
public class ReponseEvaluation implements Serializable {
    @Id
    @Column(name = "ID_REPONSE_EVALUATION")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReponseEvaluation;

    @Column(name = "ID_EVALUATION")
    private Long idEvaluation;

    @Column(name = "NO_ETUDIANT")
    private String noEtudiant;

    @Column(name = "COMMENTAIRE")
    private String commentaire;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    public Long getIdReponseEvaluation() {
        return this.idReponseEvaluation;
    }

    public void setIdReponseEvaluation(Long idReponseEvaluation) {
        this.idReponseEvaluation = idReponseEvaluation;
    }

    public Long getIdEvaluation() {
        return this.idEvaluation;
    }

    public void setIdEvaluation(Long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public String getNoEtudiant() {
        return this.noEtudiant;
    }

    public void setNoEtudiant(String noEtudiant) {
        this.noEtudiant = noEtudiant;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
