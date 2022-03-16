<<<<<<< HEAD
package fr.ubo.dosi.CSCIEVAE.repository;

import fr.ubo.dosi.CSCIEVAE.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {

    List<Enseignant> findAllByNomContainingIgnoreCase(String nom);

    List<Enseignant> findByEmailUboContainingIgnoreCase(String emailUbo);

    Enseignant findByNoEnseignant(Long noEnseignant);
}
=======
package fr.ubo.dosi.CSCIEVAE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ubo.dosi.CSCIEVAE.entity.Enseignant;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {

    List<Enseignant> findAllByNomContainingIgnoreCase(String nom);

    List<Enseignant> findByEmailUboContainingIgnoreCase(String emailUbo);

    Enseignant findByNoEnseignant(Long noEnseignant);
}
>>>>>>> master
