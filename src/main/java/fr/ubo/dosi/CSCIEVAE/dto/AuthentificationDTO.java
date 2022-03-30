package fr.ubo.dosi.CSCIEVAE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AuthentificationDTO {

    private Long idConnection;
    private String login;
    private String pwd;
    private String pseudo;
    private String role;
    private Long noEtudiant;
    private Long noEnseignant;

    public Long getIdConnection() {
        return idConnection;
    }

    public void setIdConnection(Long idConnection) {
        this.idConnection = idConnection;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getNoEtudiant() {
        return noEtudiant;
    }

    public void setNoEtudiant(Long noEtudiant) {
        this.noEtudiant = noEtudiant;
    }

    public Long getNoEnseignant() {
        return noEnseignant;
    }

    public void setNoEnseignant(Long noEnseignant) {
        this.noEnseignant = noEnseignant;
    }
}

