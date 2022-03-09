package fr.ubo.dosi.CSCIEVAE.enstities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ENSEIGNANT")
public class Enseignant implements Serializable {
    @Id
    @Column(name = "NO_ENSEIGNANT")
    private Long noEnseignant;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "SEXE")
    private String sexe;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "CODE_POSTAL")
    private String codePostal;

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "PAYS")
    private String pays;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "EMAIL_UBO")
    private String emailUbo;

    @Column(name = "EMAIL_PERSO")
    private String emailPerso;

    public Long getNoEnseignant() {
        return this.noEnseignant;
    }

    public void setNoEnseignant(Long noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSexe() {
        return this.sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
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

    public String getPays() {
        return this.pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmailUbo() {
        return this.emailUbo;
    }

    public void setEmailUbo(String emailUbo) {
        this.emailUbo = emailUbo;
    }

    public String getEmailPerso() {
        return this.emailPerso;
    }

    public void setEmailPerso(String emailPerso) {
        this.emailPerso = emailPerso;
    }
}
