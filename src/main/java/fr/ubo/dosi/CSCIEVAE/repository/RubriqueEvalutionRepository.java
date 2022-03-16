package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.RubriqueEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RubriqueEvalutionRepository extends JpaRepository<RubriqueEvaluation,Long> {

    List<RubriqueEvaluation> findAllByIdEvaluationOrderByOrdreAsc(Long idEvaluation);
}
