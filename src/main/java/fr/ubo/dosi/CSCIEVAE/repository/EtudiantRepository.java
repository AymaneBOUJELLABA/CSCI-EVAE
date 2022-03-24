package fr.ubo.dosi.CSCIEVAE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.ubo.dosi.CSCIEVAE.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>
{
	@Query(value = "SELECT * FROM ETUDIANT "
			+ "WHERE ETUDIANT.NO_ETUDIANT IN ( "
			+ "	SELECT NO_ETUDIANT FROM REPONSE_EVALUATION WHERE REPONSE_EVALUATION.ID_REPONSE_EVALUATION = ?1"
			+ ")",nativeQuery = true)
	Etudiant findByReponseEvaluation(Long idReponseEvaluation);
}
