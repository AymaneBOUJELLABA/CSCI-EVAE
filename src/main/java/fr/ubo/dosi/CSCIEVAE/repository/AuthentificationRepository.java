package fr.ubo.dosi.CSCIEVAE.repository;


import fr.ubo.dosi.CSCIEVAE.entity.Authentification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthentificationRepository extends JpaRepository<Authentification, Long> {

    //List<Authentification> findByLogin(String email);

    Authentification findByLoginAndPwd(String email, String pwd);
}
