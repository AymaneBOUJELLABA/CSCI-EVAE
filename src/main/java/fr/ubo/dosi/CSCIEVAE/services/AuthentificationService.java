package fr.ubo.dosi.CSCIEVAE.services;



import fr.ubo.dosi.CSCIEVAE.entity.Authentification;

import java.util.List;

public interface AuthentificationService {
    //public List<AuthentificationDTO> seConnecter() throws Exception;
    Authentification Sauthentifier(String email, String pwd);


}
