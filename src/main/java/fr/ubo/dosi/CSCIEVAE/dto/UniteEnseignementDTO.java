package fr.ubo.dosi.CSCIEVAE.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
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

	    
}
