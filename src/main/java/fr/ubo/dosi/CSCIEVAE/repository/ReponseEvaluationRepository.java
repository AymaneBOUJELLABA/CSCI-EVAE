package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseEvaluationRepository extends JpaRepository<ReponseEvaluation,Long>
{
	@Query(value = "SELECT r FROM ReponseEvaluation WHERE r.")
	List<ReponseEvaluation> findAllByCodeUeAndAnneUniv(String codeUe,String anneeUniv);

}
