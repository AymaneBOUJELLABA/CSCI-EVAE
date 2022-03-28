package fr.ubo.dosi.CSCIEVAE.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.ubo.dosi.CSCIEVAE.entity.Rubrique;

@Repository
public interface RubriqueRepository extends JpaRepository<Rubrique, Long>
{
	List<Rubrique> findAllByOrderByOrdreAsc();
	
	Rubrique findByDesignation(String designation);
	
	@Query(value="SELECT max(ordre) FROM rubrique", nativeQuery = true)
	Long findMaxOrdre();
	
}
