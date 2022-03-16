package fr.ubo.dosi.CSCIEVAE.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;


public class PromotionId implements Serializable{

	    private String codeFormation;
	    private String anneeUniversitaire;
		public String getCodeFormation() {
			return codeFormation;
		}
		public void setCodeFormation(String codeFormation) {
			this.codeFormation = codeFormation;
		}
		public String getAnneeUniversitaire() {
			return anneeUniversitaire;
		}
		public void setAnneeUniversitaire(String anneeUniversitaire) {
			this.anneeUniversitaire = anneeUniversitaire;
		}
		@Override
		public int hashCode() {
			return Objects.hash(anneeUniversitaire, codeFormation);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PromotionId other = (PromotionId) obj;
			return Objects.equals(anneeUniversitaire, other.anneeUniversitaire)
					&& Objects.equals(codeFormation, other.codeFormation);
		}
	    
	    

}
