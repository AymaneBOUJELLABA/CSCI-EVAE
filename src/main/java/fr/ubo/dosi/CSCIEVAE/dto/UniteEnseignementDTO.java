package fr.ubo.dosi.CSCIEVAE.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;

@Data
public class UniteEnseignementDTO {
	    private String codeUe;
	    private Long noEnseignant;
	    private String designation;
	    private String nom;
	    private String prenom;
	    private String emailUbo;
	    private String emailPerso;
	    private String mobile;
	    private String semestre;
	    private String description;
	    private Long nbhCm;
	    private Long nbhTd;
	    private Long nbhTp;
		
		public String getEmailUbo() {
			return emailUbo;
		}
		public void setEmailUbo(String emailUbo) {
			this.emailUbo = emailUbo;
		}
		public String getEmailPerso() {
			return emailPerso;
		}
		public void setEmailPerso(String emailPerso) {
			this.emailPerso = emailPerso;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getSemestre() {
			return semestre;
		}
		public void setSemestre(String semestre) {
			this.semestre = semestre;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Long getNbhCm() {
			return nbhCm;
		}
		public void setNbhCm(Long nbhCm) {
			this.nbhCm = nbhCm;
		}
		public Long getNbhTd() {
			return nbhTd;
		}
		public void setNbhTd(Long nbhTd) {
			this.nbhTd = nbhTd;
		}
		public Long getNbhTp() {
			return nbhTp;
		}
		public void setNbhTp(Long nbhTp) {
			this.nbhTp = nbhTp;
		}
		public String getCodeUe() {
			return codeUe;
		}
		public void setCodeUe(String codeUe) {
			this.codeUe = codeUe;
		}
		public Long getNoEnseignant() {
			return noEnseignant;
		}
		public void setNoEnseignant(Long noEnseignant) {
			this.noEnseignant = noEnseignant;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
	    
}
