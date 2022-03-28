package fr.ubo.dosi.CSCIEVAE.repository;


import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestion;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseQuestionRepository extends JpaRepository<ReponseQuestion, ReponseQuestionId> {


}
