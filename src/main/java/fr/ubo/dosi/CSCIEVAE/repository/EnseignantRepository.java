package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.enstities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {

    List<Enseignant> findAllByNomContainingIgnoreCase(String nom);

    List<Enseignant> findByEmailUboContainingIgnoreCase(String emailUbo);

    Enseignant findByNoEnseignant(Long noEnseignant);
}
