package fr.ubo.dosi.CSCIEVAE.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AUTHENTIFICATION")
public class Authentification implements Serializable {
    @Id
    @Column(name = "ID_CONNECTION")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idConnection;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "LOGIN_CONNECTION")
    private String login;

    @Column(name = "PSEUDO_CONNECTION")
    private String pseudo;

    @Column(name = "MOT_PASSE")
    private String pwd;

    @Column(name = "NO_ENSEIGNANT")
    private Long noEnseignant;

    @Column(name = "NO_ETUDIANT")
    private Long noEtudiant;

    public Long getIdConnection() {
        return idConnection;
    }

    public void setIdConnection(Long idConnection) {
        this.idConnection = idConnection;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getNoEnseignant() {
        return noEnseignant;
    }

    public void setNoEnseignant(Long noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public Long getNoEtudiant() {
        return noEtudiant;
    }

    public void setNoEtudiant(Long noEtudiant) {
        this.noEtudiant = noEtudiant;
    }
}

