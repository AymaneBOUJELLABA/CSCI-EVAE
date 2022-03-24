package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.dto.QuestionReponseInfoDTO;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestion;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestionId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReponseQuestionRepository extends JpaRepository<ReponseQuestion, ReponseQuestionId>
{
	@Query(value="SELECT QUESTION.ID_QUESTION, "
			+ "	 QUESTION.TYPE, "
			+ "	 QUESTION.NO_ENSEIGNANT, "
			+ "	 QUESTION.ID_QUALIFICATIF, "
			+ "	 QUESTION.INTITULE, "
			+ "	 POSITIONNEMENT, "
			+ "	 NO_ETUDIANT, "
			+ "	 REPONSE_QUESTION.ID_REPONSE_EVALUATION, "
			+ "	 QUESTION_EVALUATION.ID_RUBRIQUE_EVALUATION "
			+ "FROM QUESTION "
			+ "JOIN QUESTION_EVALUATION "
			+ "ON QUESTION_EVALUATION.ID_QUESTION = QUESTION.ID_QUESTION "
			+ "JOIN REPONSE_QUESTION "
			+ "ON REPONSE_QUESTION.ID_QUESTION_EVALUATION = QUESTION_EVALUATION.ID_QUESTION_EVALUATION "
			+ "JOIN REPONSE_EVALUATION "
			+ "ON REPONSE_EVALUATION.ID_REPONSE_EVALUATION = REPONSE_QUESTION.ID_REPONSE_EVALUATION "
			+ ";",nativeQuery = true)
	public List<QuestionReponseInfoDTO> findAllReponseQuestionInfo();

}
