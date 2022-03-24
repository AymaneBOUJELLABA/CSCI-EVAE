package fr.ubo.dosi.CSCIEVAE.services;

import fr.ubo.dosi.CSCIEVAE.repository.EtudiantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EtudiantEvaluationServiceImpl implements EtudiantEvaluationService{

    @Autowired
    private EtudiantsRepository etudiantsRepository;


    @Override
    public Long NumberOfResponses(Long idEvaluation) {
        return etudiantsRepository.NumberEtudiantRepondu(idEvaluation);
    }

    @Override
    public Long NumberOfStudents(String codeFormation, String anneeUniversitaire) {
        return etudiantsRepository.NumberEtudiant(codeFormation,anneeUniversitaire);
    }
}
