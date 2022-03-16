package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.enstities.Droit;
import fr.ubo.dosi.CSCIEVAE.enstities.DroitId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroitRepository extends JpaRepository<Droit, DroitId> {

}
