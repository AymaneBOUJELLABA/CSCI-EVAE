package fr.ubo.dosi.CSCIEVAE.services;

import fr.ubo.dosi.CSCIEVAE.repository.EtudiantsRepository;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EtudiantEvaluationServiceImpl implements EtudiantEvaluationService{

    @Autowired
    private EtudiantsRepository etudiantsRepository;
    @Autowired
    private ReponseEvaluationRepository reponseEvaluationRepository;

    @Override
    public int NumberOfResponses(Long idEvaluation) {
        //return etudiantsRepository.NumberEtudiantRepondu(idEvaluation);
        return reponseEvaluationRepository.countReponseEvaluationByIdEvaluation(idEvaluation);
    }

    @Override
    public int NumberOfStudents(String codeFormation, String anneeUniversitaire) {
        return etudiantsRepository.countByCodeFormationAndAnneeUniversitaire(codeFormation,anneeUniversitaire);
    }
}
