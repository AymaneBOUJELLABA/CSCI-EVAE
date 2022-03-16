package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.Droit;
import fr.ubo.dosi.CSCIEVAE.entity.DroitId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroitRepository extends JpaRepository<Droit, DroitId> {

}
