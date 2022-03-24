package fr.ubo.dosi.CSCIEVAE.services;

public interface EtudiantEvaluationService {

    Long NumberOfResponses(Long idEvaluation);

    Long NumberOfStudents(String codeFormation, String anneeUniversitaire);

}
