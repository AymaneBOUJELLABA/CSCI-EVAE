package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.QuestionEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionEvaluationRepository extends JpaRepository<QuestionEvaluation,Long> {

    List<QuestionEvaluation> findAllByIdRubriqueEvaluationOrderByOrdreAsc(Long idRubEva);
}
