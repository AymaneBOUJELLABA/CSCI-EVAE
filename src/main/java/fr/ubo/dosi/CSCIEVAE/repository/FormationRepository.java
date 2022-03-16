package fr.ubo.dosi.CSCIEVAE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ubo.dosi.CSCIEVAE.entity.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Long>  {

}
