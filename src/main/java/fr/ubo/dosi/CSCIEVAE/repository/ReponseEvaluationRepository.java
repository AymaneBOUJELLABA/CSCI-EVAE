package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseEvaluationRepository extends JpaRepository<ReponseEvaluation,Long>
{
	@Query(value = 
			"SELECT * "
			+ "FROM REPONSE_EVALUATION "
			+ "WHERE REPONSE_EVALUATION.ID_EVALUATION IN ( "
			+ "	SELECT ID_EVALUATION "
			+ "	FROM EVALUATION "
			+ "	WHERE EVALUATION.ANNEE_UNIVERSITAIRE = ?2 "
			+ "	AND EVALUATION.CODE_UE = ?1 "
			+ " ) ", nativeQuery = true)
	List<ReponseEvaluation> findAllByCodeUeAndAnneUniv(String codeUe,String anneeUniv);
	
	
	
	@Query(value = "SELECT * FROM REPONSE_EVALUATION "
			+ "WHERE REPONSE_EVALUATION.ID_EVALUATION IN ( "
			+ "	SELECT ID_EVALUATION FROM EVALUATION "
			+ "	WHERE EVALUATION.ANNEE_UNIVERSITAIRE = ?1 "
			+ "	AND EVALUATION.CODE_FORMATION = ?2 "
			+ ") ", nativeQuery = true)
	List<ReponseEvaluation> findAllByAnneeUnivAndCodeFormation(String anneUniv, String codeFormation);

}
