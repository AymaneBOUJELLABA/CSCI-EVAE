package fr.ubo.dosi.CSCIEVAE.services;

import fr.ubo.dosi.CSCIEVAE.dto.QuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.enstities.Evaluation;
import fr.ubo.dosi.CSCIEVAE.enstities.Question;
import fr.ubo.dosi.CSCIEVAE.enstities.Rubrique;

import java.util.List;

public interface EvaluationService {

    List<Evaluation> getAllEvalutions();

    Evaluation getEvalutionParCodeUe(String codeUe);

    Evaluation getEvalutionParId(Long id);

    List<RubriqueDTO> getRubriqueEvaluation(Long idEvaluation);

    List<QuestionDTO> getQuestionRubriqueForEvaluation(Long idRubrique);

}
