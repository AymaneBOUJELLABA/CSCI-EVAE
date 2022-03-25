package fr.ubo.dosi.CSCIEVAE.services;

public interface EtudiantEvaluationService {

    int NumberOfResponses(Long idEvaluation);

    int NumberOfStudents(String codeFormation, String anneeUniversitaire);

}
