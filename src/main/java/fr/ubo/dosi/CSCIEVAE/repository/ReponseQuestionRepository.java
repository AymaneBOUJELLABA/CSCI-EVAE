package fr.ubo.dosi.CSCIEVAE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestion;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestionId;

@Repository
public interface ReponseQuestionRepository extends JpaRepository<ReponseQuestion,ReponseQuestionId >{

}
