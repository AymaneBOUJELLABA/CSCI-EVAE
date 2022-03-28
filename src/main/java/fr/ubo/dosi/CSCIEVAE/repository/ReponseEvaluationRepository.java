package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseEvaluationRepository extends JpaRepository<ReponseEvaluation,Long> {

    int countReponseEvaluationByIdEvaluation(Long idEval);

}
