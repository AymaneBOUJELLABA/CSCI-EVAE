package fr.ubo.dosi.CSCIEVAE.dto;

import lombok.Data;

import java.util.List;

@Data
public class EvaluationDTO {

    private Long idEvaluation;
    private Long noEnseignant;
    private Long noEvaluation;
    private String codeFormation;
    private String codeUe;
    private String codeEc;
    private String anneeUniversitaire;
    private String designation;
    private String etat;
    private String periode;
    private java.sql.Date debutReponse;
    private java.sql.Date finReponse;
    private List<RubriqueDTO> rubriques;
	public Long getIdEvaluation() {
		return idEvaluation;
	}
	public void setIdEvaluation(Long idEvaluation) {
		this.idEvaluation = idEvaluation;
	}
	public Long getNoEnseignant() {
		return noEnseignant;
	}
	public void setNoEnseignant(Long noEnseignant) {
		this.noEnseignant = noEnseignant;
	}
	public Long getNoEvaluation() {
		return noEvaluation;
	}
	public void setNoEvaluation(Long noEvaluation) {
		this.noEvaluation = noEvaluation;
	}
	public String getCodeFormation() {
		return codeFormation;
	}
	public void setCodeFormation(String codeFormation) {
		this.codeFormation = codeFormation;
	}
	public String getCodeUe() {
		return codeUe;
	}
	public void setCodeUe(String codeUe) {
		this.codeUe = codeUe;
	}
	public String getCodeEc() {
		return codeEc;
	}
	public void setCodeEc(String codeEc) {
		this.codeEc = codeEc;
	}
	public String getAnneeUniversitaire() {
		return anneeUniversitaire;
	}
	public void setAnneeUniversitaire(String anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public java.sql.Date getDebutReponse() {
		return debutReponse;
	}
	public void setDebutReponse(java.sql.Date debutReponse) {
		this.debutReponse = debutReponse;
	}
	public java.sql.Date getFinReponse() {
		return finReponse;
	}
	public void setFinReponse(java.sql.Date finReponse) {
		this.finReponse = finReponse;
	}
	public List<RubriqueDTO> getRubriques() {
		return rubriques;
	}
	public void setRubriques(List<RubriqueDTO> rubriques) {
		this.rubriques = rubriques;
	}
    
    

}
