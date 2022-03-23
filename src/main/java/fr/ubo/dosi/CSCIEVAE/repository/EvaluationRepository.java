package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {

    Evaluation findByCodeUeContainingIgnoreCase(String codeUe);

    Evaluation findByAnneeUniversitaireAndCodeUeContainingIgnoreCase(String anneeUniv, String codeUe);
}
