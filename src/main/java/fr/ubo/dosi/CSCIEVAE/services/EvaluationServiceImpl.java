package fr.ubo.dosi.CSCIEVAE.services;

import fr.ubo.dosi.CSCIEVAE.dto.QuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.enstities.Evaluation;
import fr.ubo.dosi.CSCIEVAE.enstities.Qualificatif;
import fr.ubo.dosi.CSCIEVAE.enstities.Question;
import fr.ubo.dosi.CSCIEVAE.enstities.Rubrique;
import fr.ubo.dosi.CSCIEVAE.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluationServiceImpl implements EvaluationService{

    @Autowired
    private EvaluationRepository evaluationRepository;
    @Autowired
    private RubriqueEvalutionRepository rubriqueEvalutionRepository;
    @Autowired
    private RubriqueRepository rubriqueRepository;
    @Autowired
    private QuestionEvaluationRepository questionEvaluationRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QualificatifRepository qualificatifRepository;

    @Override
    public List<Evaluation> getAllEvalutions() {
        return evaluationRepository.findAll();
    }

    @Override
    public Evaluation getEvalutionParCodeUe(String codeUe) {
        return evaluationRepository.findByCodeUeContainingIgnoreCase(codeUe);
    }

    @Override
    public Evaluation getEvalutionParId(Long id) {
        if (evaluationRepository.findById(id).isPresent())
            return evaluationRepository.findById(id).get();
        else return null;
    }

    @Override
    @Transactional
    public List<RubriqueDTO> getRubriqueEvaluation(Long idEvaluation) {
        return rubriqueEvalutionRepository.findAllByIdEvaluationOrderByOrdreAsc(idEvaluation)
                .stream()
                .map(re -> {
                    RubriqueDTO rubriqueDTO = new RubriqueDTO();
                    Rubrique rubrique = rubriqueRepository.findById(re.getIdRubrique()).get();
                    if (rubriqueRepository.findById(re.getIdRubrique()).isPresent()){
                        rubriqueDTO.setIdRubrique(rubrique.getIdRubrique());
                        rubriqueDTO.setType(rubriqueDTO.getType());
                        rubriqueDTO.setDesignation(rubrique.getDesignation());
                        rubriqueDTO.setOrdre(re.getOrdre());
                        rubriqueDTO.setQuestions(
                                getQuestionRubriqueForEvaluation(rubrique.getIdRubrique())
                        );
                        return rubriqueDTO;
                    }
                    else return (RubriqueDTO) Collections.emptyList();
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<QuestionDTO> getQuestionRubriqueForEvaluation(Long idRubrique) {
        return questionEvaluationRepository.findAllByIdRubriqueEvaluationOrderByOrdreAsc(idRubrique)
                .stream()
                .map(qe -> {
                    QuestionDTO questionDTO = new QuestionDTO();
                    if (questionRepository.findById(qe.getIdQuestion()).isPresent()){
                        Question question = questionRepository.findById(qe.getIdQuestion()).get();
                        Qualificatif qualificatif = qualificatifRepository.findById(question.getIdQualificatif()).get();
                        questionDTO.setIdQuestion(question.getIdQuestion());
                        questionDTO.setIntitule(question.getIntitule());
                        questionDTO.setType(question.getType());
                        questionDTO.setNoEnseignant(question.getNoEnseignant());
                        questionDTO.setQualificatif(qualificatif);
                        questionDTO.setOrder(qe.getOrdre());
                        return questionDTO;
                    }else
                        return (QuestionDTO) Collections.emptyList();
                })
                .collect(Collectors.toList());
    }


}
