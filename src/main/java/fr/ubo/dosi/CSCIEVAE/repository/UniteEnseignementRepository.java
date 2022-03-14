package fr.ubo.dosi.CSCIEVAE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ubo.dosi.CSCIEVAE.entity.UniteEnseignement;

@Repository
public interface UniteEnseignementRepository extends JpaRepository<UniteEnseignement,Long> {

}
