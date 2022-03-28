package fr.ubo.dosi.CSCIEVAE.entity;

import javax.persistence.*;

@Entity
@Table(name = "AUTHENTIFICATION")
public class Authentification {
    @Id
    @Column(name = "ID_CONNECTION")
    private Long idConnection;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "LOGIN_CONNECTION")
    private String loginConnection;

    @Column(name = "PSEUDO_CONNECTION")
    private String pseudoConnection;

    @Column(name = "MOT_PASSE")
    private String motPasse;

    @Column(name = "NO_ENSEIGNANT")
    private Long noEnseignant;

    @Column(name = "NO_ETUDIANT")
    private String noEtudiant;

    public Long getIdConnection() {
        return this.idConnection;
    }

    public void setIdConnection(Long idConnection) {
        this.idConnection = idConnection;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLoginConnection() {
        return this.loginConnection;
    }

    public void setLoginConnection(String loginConnection) {
        this.loginConnection = loginConnection;
    }

    public String getPseudoConnection() {
        return this.pseudoConnection;
    }

    public void setPseudoConnection(String pseudoConnection) {
        this.pseudoConnection = pseudoConnection;
    }

    public String getMotPasse() {
        return this.motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public Long getNoEnseignant() {
        return this.noEnseignant;
    }

    public void setNoEnseignant(Long noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public String getNoEtudiant() {
        return this.noEtudiant;
    }

    public void setNoEtudiant(String noEtudiant) {
        this.noEtudiant = noEtudiant;
    }
}
