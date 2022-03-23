package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificatifRepository extends JpaRepository<Qualificatif, Long> {



}
