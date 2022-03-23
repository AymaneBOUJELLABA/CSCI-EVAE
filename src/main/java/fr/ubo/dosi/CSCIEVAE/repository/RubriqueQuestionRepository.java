package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.RubriqueQuestion;
import fr.ubo.dosi.CSCIEVAE.entity.RubriqueQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubriqueQuestionRepository extends JpaRepository<RubriqueQuestion, RubriqueQuestionId> {

    List<RubriqueQuestion> findAllByIdRubriqueOrderByOrdreAsc(Long id);

}
