package fr.ubo.dosi.CSCIEVAE.enstities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ETUDIANT")
public class Etudiant implements Serializable {
    @Id
    @Column(name = "NO_ETUDIANT")
    private String noEtudiant;

    @Column(name = "CODE_FORMATION")
    private String codeFormation;

    @Column(name = "ANNEE_UNIVERSITAIRE")
    private String anneeUniversitaire;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "SEXE")
    private String sexe;

    @Column(name = "DATE_NAISSANCE")
    private java.sql.Date dateNaissance;

    @Column(name = "LIEU_NAISSANCE")
    private String lieuNaissance;

    @Column(name = "NATIONALITE")
    private String nationalite;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "EMAIL_UBO")
    private String emailUbo;

    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "CODE_POSTAL")
    private String codePostal;

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "PAYS_ORIGINE")
    private String paysOrigine;

    @Column(name = "UNIVERSITE_ORIGINE")
    private String universiteOrigine;

    @Column(name = "GROUPE_TP")
    private Long groupeTp;

    @Column(name = "GROUPE_ANGLAIS")
    private Long groupeAnglais;

    public String getNoEtudiant() {
        return this.noEtudiant;
    }

    public void setNoEtudiant(String noEtudiant) {
        this.noEtudiant = noEtudiant;
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

    public String getSexe() {
        return this.sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public java.sql.Date getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(java.sql.Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return this.lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNationalite() {
        return this.nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailUbo() {
        return this.emailUbo;
    }

    public void setEmailUbo(String emailUbo) {
        this.emailUbo = emailUbo;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPaysOrigine() {
        return this.paysOrigine;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public String getUniversiteOrigine() {
        return this.universiteOrigine;
    }

    public void setUniversiteOrigine(String universiteOrigine) {
        this.universiteOrigine = universiteOrigine;
    }

    public Long getGroupeTp() {
        return this.groupeTp;
    }

    public void setGroupeTp(Long groupeTp) {
        this.groupeTp = groupeTp;
    }

    public Long getGroupeAnglais() {
        return this.groupeAnglais;
    }

    public void setGroupeAnglais(Long groupeAnglais) {
        this.groupeAnglais = groupeAnglais;
    }
}
