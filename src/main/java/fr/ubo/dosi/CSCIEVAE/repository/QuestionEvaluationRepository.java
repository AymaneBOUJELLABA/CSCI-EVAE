package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.QuestionEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionEvaluationRepository extends JpaRepository<QuestionEvaluation,Long> {

    List<QuestionEvaluation> findAllByIdRubriqueEvaluationOrderByOrdreAsc(Long idRubEva);

    void deleteAllByIdRubriqueEvaluation(long idRubEva);

}
