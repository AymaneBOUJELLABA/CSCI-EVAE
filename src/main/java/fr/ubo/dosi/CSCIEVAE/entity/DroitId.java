package fr.ubo.dosi.CSCIEVAE.entity;

import java.io.Serializable;
import java.util.Objects;



public class DroitId implements Serializable{
	    private Long idEvaluation;
	    private Long noEnseignant;
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
		@Override
		public int hashCode() {
			return Objects.hash(idEvaluation, noEnseignant);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DroitId other = (DroitId) obj;
			return Objects.equals(idEvaluation, other.idEvaluation) && Objects.equals(noEnseignant, other.noEnseignant);
		}
	    
	    

}
