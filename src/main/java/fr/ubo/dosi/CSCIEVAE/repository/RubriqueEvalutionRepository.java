package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.RubriqueEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubriqueEvalutionRepository extends JpaRepository<RubriqueEvaluation,Long> {

    List<RubriqueEvaluation> findAllByIdEvaluationOrderByOrdreAsc(Long idEvaluation);
    
    void deleteAllByIdEvaluation(Long idEva);
}
