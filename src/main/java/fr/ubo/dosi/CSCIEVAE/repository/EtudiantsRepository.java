package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EtudiantsRepository extends JpaRepository<Etudiant, String> {

    @Query(value ="SELECT count(no_etudiant) FROM etudiant e WHERE e.code_formation = ?1 AND e.annee_universitaire = ?2 " , nativeQuery = true)
    Long NumberEtudiant(String codeFormation, String anneeUniversitaire);

    int countByCodeFormationAndAnneeUniversitaire(String codeFormation, String anneeUniversitaire);
}
