package fr.ubo.dosi.CSCIEVAE.dto;

import lombok.Data;

import java.util.List;

@Data
public class RubriqueDTO {

    private Long idRubrique;
    private String type;
    private String designation;
    private Long ordre;
    private List<QuestionDTO> questions;
	public Long getIdRubrique() {
		return idRubrique;
	}
	public void setIdRubrique(Long idRubrique) {
		this.idRubrique = idRubrique;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Long getOrdre() {
		return ordre;
	}
	public void setOrdre(Long ordre) {
		this.ordre = ordre;
	}
	public List<QuestionDTO> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}
    
    

}
