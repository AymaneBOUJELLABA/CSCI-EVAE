package fr.ubo.dosi.CSCIEVAE.services;

import fr.ubo.dosi.CSCIEVAE.entity.Authentification;
import fr.ubo.dosi.CSCIEVAE.repository.AuthentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@Log4j2
public class AuthentificationServiceImpl implements AuthentificationService{

    @Autowired
    private AuthentificationRepository authentificationRepository;
/*
if (evaluationRepository.findById(id).isPresent()) {
            log.info("Recherche d'une évaluation par ID " + id + " en service");
            return evaluationRepository.findById(id).get();
        }else
            log.info("La recherche d'une évaluation par ID " + id + ", n'existe pas");
            return null;
 */
    @Override
    public Authentification Sauthentifier(String email, String pwd) {
        Authentification authentification = authentificationRepository.findByLoginAndPwd(email,pwd);
        //List<Authentification> authentifications = authentificationRepository.findByLoginAndPwd(email,pwd);
        if(authentification!=null) {
            log.info("user trouvé");
            return authentification;
        }
        else
        {
            log.info("user non trouvé");
            return null;
        }/*
        if(authentificationRepository.findByLoginAndPwd(email,pwd).get(0).isPresent()) {
            return authentificationRepository.findByLoginAndPwd(email,pwd).get(0);
        } else
            return null;*/
    }
}
