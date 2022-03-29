package fr.ubo.dosi.CSCIEVAE.controllers;


import fr.ubo.dosi.CSCIEVAE.dto.AuthentificationDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Authentification;
import fr.ubo.dosi.CSCIEVAE.exceptions.AuthentificationNotFoundException;
import fr.ubo.dosi.CSCIEVAE.services.AuthentificationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.ubo.dosi.CSCIEVAE.utils.DataMapper;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/connexion")
@Log4j2
public class AuthentificationController {

    @Autowired
    private AuthentificationService authentificationService;

    @Autowired
    private DataMapper dataMapper;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AuthentificationDTO> seConnecter(@RequestBody AuthentificationDTO authentificationDTO){

        Authentification authentification = authentificationService.Sauthentifier((String) authentificationDTO.getLogin(), (String) authentificationDTO.getPwd());
        if (authentification == null){
            {
                log.error("user non trouvé");
                log.info("authentification: "+authentification);
                //throw new AuthentificationNotFoundException(HttpStatus.NOT_FOUND,"user non trouvé");
                AuthentificationDTO authentificationDTO1 = new AuthentificationDTO(
                        null,
                        "",
                        "",
                        "",
                        "",
                        null,
                        null
                );
                return new ResponseEntity<>(
                        authentificationDTO,
                        HttpStatus.NOT_FOUND);

            }
        }else{
            log.info("authentification: "+authentification);
           AuthentificationDTO _authentificationDTO = dataMapper.authentificationMapperToDTO(authentification);
            log.info("user trouvé; login: " + authentificationDTO.getLogin() + "  ------ password: "+ authentificationDTO.getPwd());
            return new ResponseEntity<>(
                    _authentificationDTO,
                    HttpStatus.FOUND);
            //return authentification;
        }
    }

}
