package fr.ubo.dosi.CSCIEVAE.entity;


import java.io.Serializable;
import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReponseQuestionId implements Serializable{
	private Long idReponseEvaluation;
    private Long idQuestionEvaluation;
    
	@Override
	public int hashCode() {
		return Objects.hash(idQuestionEvaluation, idReponseEvaluation);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReponseQuestionId other = (ReponseQuestionId) obj;
		return Objects.equals(idQuestionEvaluation, other.idQuestionEvaluation)
				&& Objects.equals(idReponseEvaluation, other.idReponseEvaluation);
	}
    
    
}


