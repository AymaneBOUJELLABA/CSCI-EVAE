package fr.ubo.dosi.CSCIEVAE.utils;

import fr.ubo.dosi.CSCIEVAE.dto.EtudiantDTO;
import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.QuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseEvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseQuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import fr.ubo.dosi.CSCIEVAE.entity.Question;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestion;
import fr.ubo.dosi.CSCIEVAE.entity.Rubrique;
import fr.ubo.dosi.CSCIEVAE.entity.RubriqueQuestion;

import java.util.List;

import fr.ubo.dosi.CSCIEVAE.dto.UniteEnseignementDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Enseignant;
import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import fr.ubo.dosi.CSCIEVAE.entity.UniteEnseignement;
import fr.ubo.dosi.CSCIEVAE.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class DataMapper {
	


    public EvaluationDTO evaluationMapperToDTO(Evaluation eva){
        EvaluationDTO evaDto = new EvaluationDTO();
        evaDto.setAnneeUniversitaire(eva.getAnneeUniversitaire());
        evaDto.setCodeEc(eva.getCodeEc());
        evaDto.setCodeFormation(eva.getCodeFormation());
        evaDto.setCodeUe(eva.getCodeUe());
        evaDto.setDebutReponse(eva.getDebutReponse());
        evaDto.setDesignation(eva.getDesignation());
        evaDto.setEtat(eva.getEtat());
        evaDto.setFinReponse(eva.getFinReponse());
        evaDto.setIdEvaluation(eva.getIdEvaluation());
        evaDto.setNoEnseignant(eva.getNoEnseignant());
        evaDto.setNoEvaluation(eva.getNoEvaluation());
        evaDto.setPeriode(eva.getPeriode());
        return evaDto;
    }
    
    public RubriqueDTO rubriqueMapperToDTO(Rubrique rub,List<QuestionDTO> questions)
    {
    	RubriqueDTO rubDto = new RubriqueDTO();
    	
    	rubDto.setDesignation(rub.getDesignation());
    	rubDto.setIdRubrique(rub.getIdRubrique());
    	rubDto.setOrdre(rub.getOrdre());
    	rubDto.setQuestions(questions);
    	rubDto.setType(rub.getType());
    	
    	return rubDto;
    }
    
    
    public QuestionDTO questionMapperToDTO(Question q,RubriqueQuestion rq,Qualificatif qf) throws Exception
    {
    	QuestionDTO question = new QuestionDTO();
    	
    	question.setIdQuestion(q.getIdQualificatif());
    	question.setIntitule(q.getIntitule());
    	question.setNoEnseignant(q.getNoEnseignant());
    	if(q.getIdQuestion() == rq.getIdQuestion())
    		question.setOrder(rq.getOrdre());
    	else
    		throw new Exception("Rubriques Question et Question ne sont pas lié");
    	if(q.getIdQualificatif().equals(qf.getIdQualificatif()))
    		question.setQualificatif(qf);
    	else
    		throw new Exception("Qualificatif et Question ne sont pas lié");
    	question.setType(q.getType());
    	return question;

    }
    public Evaluation evaluationDtoToEvaluation(EvaluationDTO evaluationDTO){
    	
        Evaluation eva = new Evaluation();
        eva.setIdEvaluation(evaluationDTO.getIdEvaluation());
        eva.setNoEvaluation(evaluationDTO.getNoEvaluation());
        eva.setAnneeUniversitaire(evaluationDTO.getAnneeUniversitaire());
        eva.setCodeEc(evaluationDTO.getCodeEc());
        eva.setCodeFormation(evaluationDTO.getCodeFormation());
        eva.setCodeUe(evaluationDTO.getCodeUe());
        eva.setDebutReponse(evaluationDTO.getDebutReponse());
        eva.setDesignation(evaluationDTO.getDesignation());
        eva.setEtat(evaluationDTO.getEtat());
        eva.setFinReponse(evaluationDTO.getFinReponse());
        eva.setNoEnseignant(evaluationDTO.getNoEnseignant());
        eva.setPeriode(evaluationDTO.getPeriode());
        return eva;
    }
    
    public ReponseEvaluationDTO RepEvaltoRepEvalDTO(EtudiantDTO e, EvaluationDTO eval , List<ReponseQuestionDTO> qst)
    {
    	ReponseEvaluationDTO r = new ReponseEvaluationDTO();
    	r.setEtudiant(e);
    	r.setEvaluation(eval);
    	r.setQuestions(qst);
    	
    	return r;
    }
    
    public ReponseQuestionDTO RepQuestoRepQuesDTO(ReponseQuestion q,QuestionDTO qst)
    {
    	ReponseQuestionDTO r = new ReponseQuestionDTO();
    	r.setIdQuestionEvaluation(q.getIdQuestionEvaluation());
    	r.setIdReponseEvaluation(q.getIdReponseEvaluation());
    	r.setPositionnement(q.getPositionnement());
    	r.setQuestion(qst);
    	
    	return r;
    }

}
