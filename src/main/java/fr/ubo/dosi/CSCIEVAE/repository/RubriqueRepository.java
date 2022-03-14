package fr.ubo.dosi.CSCIEVAE.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ubo.dosi.CSCIEVAE.enstities.Rubrique;

@Repository
public interface RubriqueRepository extends JpaRepository<Rubrique, Long>
{
	List<Rubrique> findAllOrderByOrdreAsc();
}
