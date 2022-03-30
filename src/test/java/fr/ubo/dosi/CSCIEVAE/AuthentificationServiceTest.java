package fr.ubo.dosi.CSCIEVAE;

import static org.junit.Assert.assertEquals;

import fr.ubo.dosi.CSCIEVAE.entity.Authentification;
import fr.ubo.dosi.CSCIEVAE.services.AuthentificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthentificationServiceTest {
    @Autowired
    private AuthentificationService authentificationService;


    @Test
    public void SauthentifierTest()
            throws Exception {
        Authentification authentification = authentificationService.Sauthentifier("philippe.saliou@univ-brest.fr","dosi");
        //Evaluation eva= evaluationService.getEvalutionParCodeUeAndAnneeUniv("ISI","2014-2015");


        assertEquals("philippe.saliou@univ-brest.fr",authentification.getLogin());
        assertEquals("dosi",authentification.getPwd());
        assertEquals("psaliou",authentification.getPseudo());
        assertEquals("ENS",authentification.getRole());
    }





}


