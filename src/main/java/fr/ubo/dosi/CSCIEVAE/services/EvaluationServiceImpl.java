package fr.ubo.dosi.CSCIEVAE.services;

import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.QuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.StatReponseQuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.StatRubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.dto.StatEvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.entity.*;
import fr.ubo.dosi.CSCIEVAE.exceptions.EvaluationErrorException;
import fr.ubo.dosi.CSCIEVAE.exceptions.EvaluationUpdateErrorException;
import fr.ubo.dosi.CSCIEVAE.exceptions.QuestionsEvaluationErrorException;
import fr.ubo.dosi.CSCIEVAE.exceptions.RubriquesEvaluationErrorException;
import fr.ubo.dosi.CSCIEVAE.repository.*;
import fr.ubo.dosi.CSCIEVAE.utils.DataMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@Transactional
@Log
public class EvaluationServiceImpl implements EvaluationService{

    @Autowired
    private EvaluationRepository evaluationRepository;
    @Autowired
    private RubriqueEvalutionRepository rubriqueEvalutionRepository;
    @Autowired
    private RubriqueRepository rubriqueRepository;
    @Autowired
    private RubriqueQuestionRepository rubriqueQuestionRepository;
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
    @Autowired
    private ReponseQuestionRepository reponseQuestionRepository;
    @Autowired
	private ReponseQuestionService reponseQustionService;
    @Autowired
	private RubriqueEvaluationService rubriqueEvaluationService;


       @Override
    public List<Evaluation> getAllEvalutions() {
        //log.info("Recherche de toutes les évaluation en service");
        return evaluationRepository.findAll();
    }

   @Override

    public Evaluation getEvalutionParCodeUeAndAnneeUniv(String codeUe, String anneeUniv) {
        log.info("Recherche de évaluation associée à une UE de code "+codeUe
                        + "pour l'année univercitaire " + anneeUniv +", en service");
       return evaluationRepository.

               findByAnneeUniversitaireAndCodeUeContainingIgnoreCase(anneeUniv,codeUe);}

    public Evaluation getEvalutionParCodeUe(String codeUe) {
       /*log.info("Recherche de évaluation associée à une UE de code "+codeUe+
                " en service");*/
        Evaluation eva = evaluationRepository.findByCodeUeContainingIgnoreCase(codeUe);

        return evaluationRepository.findByCodeUeContainingIgnoreCase(codeUe);


    }

    @Override
    public Evaluation getEvalutionParId(Long id) {

        if (evaluationRepository.findById(id).isPresent()) {

            log.info("Recherche d'une évaluation par ID " + id + " en service");
            return evaluationRepository.findById(id).get();
        }else {
            log.info("La recherche d'une évaluation par ID " + id + ", n'existe pas");


            return null;

    }}

    @Override
    @Transactional
    public List<RubriqueDTO> getRubriqueEvaluation(Long idEvaluation) {
           log.info(" Recherche des rubriques évaluation par ID eval : "+ idEvaluation);
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
                                getQuestionRubriqueForEvaluation(re.getIdRubriqueEvaluation())
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
//                        if (qualificatifRepository.findById(question.getIdQualificatif()).isPresent())
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

    @Transactional
    @Override


    public EvaluationDTO createEvaluation(EvaluationDTO evaluationDTO) {
        log.info("--- Start Evalution Creation ---");

        Evaluation eva = dataMapper.evaluationDtoToEvaluation(evaluationDTO);
        try {
            eva = evaluationRepository.save(eva);
            Evaluation finalEva = eva;
            if (finalEva.getIdEvaluation() == null) {
                //log.error(" Problème dans la création de l'évaluation !");
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
            associerRubriquesToEvaluation(finalEva, evaluationDTO.getRubriques());
            log.info(" Les rubriques sont associées avec success à l'évalution ");


            //log.info(" Droits evaluation associer avec success ");
            //log.info(" __ Assossier les rubriques à l'évalution __ ");
            associetRubriquesToEvaluation(finalEva, evaluationDTO.getRubriques());
            //log.info(" Les rubriques sont associées avec success à l'évalution ");


            EvaluationDTO newEvaDTO = dataMapper.evaluationMapperToDTO(finalEva);
            newEvaDTO.setRubriques(getRubriqueEvaluation(finalEva.getIdEvaluation()));
            //log.info("Evalution est associée aux rubriques avec success !");
            return newEvaDTO;
        }catch (Exception e){
            throw new EvaluationErrorException(e.getMessage());
        }
    }

    @Override

    public void associerRubriquesToEvaluation(Evaluation finalEva, List<RubriqueDTO> rubriquesDto) {
        log.info(" __ Assossiation des rubriques à l'évalution encours __ ");
        try {
            List<RubriqueEvaluation> rubriqueEvaluations = new ArrayList<>();
            rubriquesDto.forEach(rubriqueDTO -> {
                RubriqueEvaluation rubEva = new RubriqueEvaluation(
                        null,
                        finalEva.getIdEvaluation(),
                        rubriqueDTO.getIdRubrique(),
                        (long) rubriquesDto.indexOf(rubriqueDTO) + 1,
                        rubriqueDTO.getType()
                );
                rubEva = rubriqueEvalutionRepository.save(rubEva);
                rubriqueEvaluations.add(rubriqueEvalutionRepository.save(rubEva));
            });
            setQuestionsEvaluationForRubsEval(rubriqueEvaluations);
        }catch (Exception e){
            throw new RubriquesEvaluationErrorException(
                    HttpStatus.CONFLICT,
                    "Une erreur pendant l'association des rubriqueq à l'évaluation | "
                    + e.getMessage()
            );
        }
    }

    @Override
    public void setQuestionsEvaluationForRubsEval(List<RubriqueEvaluation> rubriquesEvaluation) {
           log.info(" ___ Start association of questions to Rubriques evaluation ___");
        try {
            rubriquesEvaluation.forEach(rubriqueEvaluation -> {
                log.info(" -> For Rubrique Eva : " + rubriqueEvaluation.getIdRubriqueEvaluation());
                List<QuestionEvaluation> questionEvaluations =
                        rubriqueQuestionRepository.findAllByIdRubriqueOrderByOrdreAsc(rubriqueEvaluation.getIdRubrique())
                                .stream()
                                .map(rubriqueQuestion -> {
                                    if (questionRepository.findById(rubriqueQuestion.getIdQuestion()).isPresent()) {
                                        return new QuestionEvaluation(
                                                null,
                                                rubriqueEvaluation.getIdRubriqueEvaluation(),
                                                rubriqueQuestion.getIdQuestion(),
                                                null,
                                                rubriqueQuestion.getOrdre(),
                                                "");
                                    } else return null;
                                })
                                .collect(Collectors.toList());
                questionEvaluations = questionEvaluationRepository.saveAll(questionEvaluations);
            });
        }catch (Exception e){
            throw new QuestionsEvaluationErrorException(
                    HttpStatus.CONFLICT,
                    "Erreur pendant l'association des questions à l'évaluation | "
                            + e.getMessage()
            );
        }
        log.info(" ___ End association of questions to Rubriques evaluation ___");
    }

  /*  @Override
    @Transactional
    public EvaluationDTO updateRubriquesEvaluationOrder(EvaluationDTO evaluationDTO) {
        log.info(" __ Updates sur les rubriques associées aux évaluations __ ");
        if (!evaluationDTO.getEtat().equals("ELA"))
            throw new EvaluationUpdateErrorException(
                    HttpStatus.NOT_ACCEPTABLE,

                    "L'évaluation est déja publiée vous ne pouvez pas faire des modification !");}*/

    @Override
    public void associetRubriquesToEvaluation(Evaluation finalEva, List<RubriqueDTO> rubriquesDto) {
   /*    //log.info(" __ Assossiation des rubriques à l'évalution encours __ ");
    	
        int i= 0;
        rubriquesDto.forEach(rubriqueDTO -> {
            RubriqueEvaluation rubEva = new RubriqueEvaluation(
                    null,
                    finalEva.getIdEvaluation(),
                    rubriqueDTO.getIdRubrique(),
                    (long) i+1,
                    rubriqueDTO.getType()


                    "L'évaluation est déja publiée vous ne pouvez pas faire des modification !"

            );
        if (!rubriqueEvalutionRepository.findAllByIdEvaluationOrderByOrdreAsc(evaluationDTO.getIdEvaluation())
                .isEmpty())
        {
            rubriqueEvalutionRepository.findAllByIdEvaluationOrderByOrdreAsc(evaluationDTO.getIdEvaluation())
                    .forEach(rubriqueEvaluation ->{
                if (!questionEvaluationRepository
                        .findAllByIdRubriqueEvaluationOrderByOrdreAsc(
                                rubriqueEvaluation.getIdRubriqueEvaluation())
                        .isEmpty()
                ) {
                    log.info("  ___ Suppression des Questions Eval assosier à la Rub Eva ___");
                    questionEvaluationRepository.deleteAllByIdRubriqueEvaluation(
                            rubriqueEvaluation.getIdRubriqueEvaluation()
                    );
                }
                    });
            log.info("  ___ Suppression des Rub Eva associer à l'évaluation ___");
            rubriqueEvalutionRepository.deleteAllByIdEvaluation(evaluationDTO.getIdEvaluation());
        }
        Evaluation evaluation = dataMapper.evaluationDtoToEvaluation(evaluationDTO);
        log.info(" -- Associer l'evaluation au nouveaux rubriques -- ");
        associerRubriquesToEvaluation(evaluation, evaluationDTO.getRubriques());
        evaluationDTO.setRubriques(getRubriqueEvaluation(evaluation.getIdEvaluation()));
        log.info("-- Evaluation updated successfully --");
        return evaluationDTO;*/
    }

    @Override
    @Transactional
    public List<QuestionDTO> getQuestionsEvalForRubriqueEval(Long idRubEval) {
           return  questionEvaluationRepository.findAllByIdRubriqueEvaluationOrderByOrdreAsc(idRubEval)
                   .stream()
                    .map(questionEvaluation -> {
                       QuestionDTO questionDTO = new QuestionDTO();
                       if (questionRepository.findById(questionEvaluation.getIdQuestion()).isPresent()) {
                           Question question = questionRepository.findById(questionEvaluation.getIdQuestion()).get();
                           questionDTO.setIdQuestion(question.getIdQuestion());
                           questionDTO.setIntitule(question.getIntitule());
                           questionDTO.setNoEnseignant(question.getNoEnseignant());
                           questionDTO.setOrder(questionEvaluation.getOrdre());
                           questionDTO.setType(questionDTO.getType());
                           //log.info("looking for Qualificatif with ID : "+question.getIdQualificatif());
                           Qualificatif qualificatif = qualificatifRepository.findById(question.getIdQualificatif()).get();
                           //log.info("Found Qualificatif for question :" +qualificatif.toString());
                           questionDTO.setQualificatif(qualificatif);
                           return questionDTO;
                       }else
                           return (QuestionDTO) Collections.emptyList();
                    })
           .collect(Collectors.toList());

    }

    @Override
    public Evaluation publierEvaluation(Evaluation evaluation) {
           log.info(" -- Start publishing in service --");
           if (getRubriqueEvaluation(evaluation.getIdEvaluation()).isEmpty()){
               log.info(" !! Evaluation can't be published bcs it has no content !!");
               throw new EvaluationUpdateErrorException(
                       HttpStatus.NO_CONTENT,
                       "Cette évaluation n'a pas encore des questionnaires pour être compléte et publiée !"
               );
           }else {
               evaluation.setEtat("DIS");
               return evaluationRepository.save(evaluation);
           }
    }
    

    
    
    
    
	@Override
	public List<StatRubriqueDTO> getStatRubriques(Long idEval) {
		List<RubriqueEvaluation> rubriques = this.rubriqueEvaluationService.findAllByIdEvaluationOrderByOrdreAsc(idEval);
		List<StatRubriqueDTO> statRubriques = new ArrayList<StatRubriqueDTO>();
		//mapping de chaque rubrique  de rubrique à stat rubrique dto
		for(int i= 0; i<rubriques.size(); i++) {
			StatRubriqueDTO statRubrique = new StatRubriqueDTO();
			statRubrique.setIdRubrique(rubriques.get(i).getIdRubrique());
			statRubrique.setDesignation(rubriques.get(i).getDesignation());			
			// cas ou la designation est nulle			
			if(rubriques.get(i).getDesignation()== null) {				
				Rubrique rubrique = this.rubriqueRepository.getById(rubriques.get(i).getIdRubrique());
				statRubrique.setDesignation(rubrique.getDesignation());				
			}
			statRubrique.setOrdre(rubriques.get(i).getOrdre());			
			//get question evaluation par rubrique!!
			List<StatReponseQuestionDTO> statQuestions = new ArrayList<StatReponseQuestionDTO>();
			List<QuestionEvaluation> questions = this.questionEvaluationRepository.findAllByIdRubriqueEvaluationOrderByOrdreAsc(rubriques.get(i).getIdRubriqueEvaluation());
			for(int j =0; j<questions.size(); j++) {
				StatReponseQuestionDTO statRepQuest = this.reponseQustionService.getStatReponseQuestion(questions.get(j).getIdQuestionEvaluation());
				statQuestions.add(statRepQuest);				
			}			
			statRubrique.setQuestions(statQuestions);
			statRubriques.add(statRubrique);			
		}
		return statRubriques;
	}

	@Override
	public StatEvaluationDTO getStatEvaluation(Long idEvaluation) {
		Evaluation eva = this.evaluationRepository.getById(idEvaluation);
		StatEvaluationDTO statEva = new StatEvaluationDTO();
		statEva.setIdEvaluation(idEvaluation);
		statEva.setAnneeUniversitaire(eva.getAnneeUniversitaire());
		statEva.setCodeEc(eva.getCodeEc());
		statEva.setCodeFormation(eva.getCodeFormation());
		statEva.setCodeUe(eva.getCodeUe());
		statEva.setDebutReponse(eva.getDebutReponse());
		statEva.setDesignation(eva.getDesignation());
		statEva.setEtat(eva.getEtat());
		statEva.setFinReponse(eva.getFinReponse());
		statEva.setNoEnseignant(eva.getNoEnseignant());
		statEva.setNoEvaluation(eva.getNoEvaluation());
		statEva.setPeriode(eva.getPeriode());
		
		
		
		statEva.setRubriques(this.getStatRubriques(idEvaluation));
		return statEva;
	}

	@Override
	public EvaluationDTO createEvalution(EvaluationDTO evaluationDTO) {
		// TODO Auto-generated method stub
		return null;
	}





	


    

    
    

}
