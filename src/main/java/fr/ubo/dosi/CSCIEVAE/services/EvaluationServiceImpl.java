package fr.ubo.dosi.CSCIEVAE.services;

import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.QuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.entity.*;
import fr.ubo.dosi.CSCIEVAE.exceptions.EvaluationErrorException;
import fr.ubo.dosi.CSCIEVAE.repository.*;
import fr.ubo.dosi.CSCIEVAE.utils.DataMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Log4j2
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
    @Autowired
    private DroitRepository droitRepository;
    @Autowired
    private DataMapper dataMapper;

       @Override
    public List<Evaluation> getAllEvalutions() {
        //log.info("Recherche de toutes les évaluation en service");
        return evaluationRepository.findAll();
    }

   @Override
    public Evaluation getEvalutionParCodeUe(String codeUe) {
        log.info("Recherche de évaluation associée à une UE de code "+codeUe+
                " en service");
        Evaluation eva = evaluationRepository.findByCodeUeContainingIgnoreCase(codeUe);

        return evaluationRepository.findByCodeUeContainingIgnoreCase(codeUe);
    }

    @Override
    public Evaluation getEvalutionParId(Long id) {

        if (evaluationRepository.findById(id).isPresent()) {
            log.info("Recherche d'une évaluation par ID " + id + " en service");
            return evaluationRepository.findById(id).get();
        }else
            log.info("La recherche d'une évaluation par ID " + id + ", n'existe pas");
            return null;
    }

    @Override
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

    @Override
    public List<Rubrique> getRubriquesForEvaluationCreation() {
        return rubriqueRepository.findAll(
                Sort.by(Sort.Direction.ASC,"ordre")
        );
    }

    @Override
    @Transactional
    public EvaluationDTO createEvalution(EvaluationDTO evaluationDTO) {
        log.info("--- Start Evalution Creation ---");
        Evaluation eva = dataMapper.evaluationDtoToEvaluation(evaluationDTO);
        try {
            eva = evaluationRepository.save(eva);
            Evaluation finalEva = eva;
            if (finalEva.getIdEvaluation() == null) {
                log.error(" Problème dans la création de l'évaluation !");
                throw new EvaluationErrorException();
            } else
                log.info(" Evalution créer avec success, " + finalEva.getIdEvaluation());
            log.info(" Donner les droits associer à une évaluation");
            droitRepository.save(new Droit(
                    finalEva.getIdEvaluation(),
                    finalEva.getNoEnseignant(),
                    "O",
                    "N"
            ));
            log.info(" Droits evaluation associer avec success ");
            log.info(" __ Assossier les rubriques à l'évalution __ ");
            associetRubriquesToEvaluation(finalEva, evaluationDTO.getRubriques());
            log.info(" Les rubriques sont associées avec success à l'évalution ");
            EvaluationDTO newEvaDTO = dataMapper.evaluationMapperToDTO(finalEva);
            newEvaDTO.setRubriques(getRubriqueEvaluation(finalEva.getIdEvaluation()));
            log.info("Evalution est associée aux rubriques avec success !");
            return newEvaDTO;
        }catch (Exception e){
            throw new EvaluationErrorException(e.getMessage());
        }
    }

    @Override
    public void associetRubriquesToEvaluation(Evaluation finalEva, List<RubriqueDTO> rubriquesDto) {
        log.info(" __ Assossiation des rubriques à l'évalution encours __ ");
        int i= 0;
        rubriquesDto.forEach(rubriqueDTO -> {
            RubriqueEvaluation rubEva = new RubriqueEvaluation(
                    null,
                    finalEva.getIdEvaluation(),
                    rubriqueDTO.getIdRubrique(),
                    (long) i+1,
                    rubriqueDTO.getType()
            );
            rubriqueEvalutionRepository.save(rubEva);
        });
    }

}
