package fr.ubo.dosi.CSCIEVAE.services;

import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.QuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.StatReponseQuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.StatRubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.dto.StatEvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import fr.ubo.dosi.CSCIEVAE.entity.QuestionEvaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestion;
import fr.ubo.dosi.CSCIEVAE.entity.Rubrique;
import fr.ubo.dosi.CSCIEVAE.entity.RubriqueEvaluation;

import java.util.List;

public interface EvaluationService {

    List<Evaluation> getAllEvalutions();

    Evaluation getEvalutionParCodeUe(String codeUe);

    Evaluation getEvalutionParId(Long id);

    List<RubriqueDTO> getRubriqueEvaluation(Long idEvaluation);
    List<QuestionDTO> getQuestionRubriqueForEvaluation(Long idRubrique);
    List<Rubrique> getRubriquesForEvaluationCreation();
    List<StatRubriqueDTO> getStatRubriques(Long idEvaluation);
    StatEvaluationDTO getStatEvaluation(Long idEvaluation);
    EvaluationDTO createEvalution(EvaluationDTO evaluationDTO);
    void associetRubriquesToEvaluation(Evaluation finalEva,List<RubriqueDTO> rubriquesDto);

}
