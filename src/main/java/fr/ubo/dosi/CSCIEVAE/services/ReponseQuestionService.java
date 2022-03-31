package fr.ubo.dosi.CSCIEVAE.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ubo.dosi.CSCIEVAE.dto.StatReponseQuestionDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import fr.ubo.dosi.CSCIEVAE.entity.Question;
import fr.ubo.dosi.CSCIEVAE.entity.QuestionEvaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestion;
import fr.ubo.dosi.CSCIEVAE.entity.RubriqueEvaluation;
import fr.ubo.dosi.CSCIEVAE.entity.UniteEnseignement;
import fr.ubo.dosi.CSCIEVAE.repository.EnseignantRepository;
import fr.ubo.dosi.CSCIEVAE.repository.EvaluationRepository;
import fr.ubo.dosi.CSCIEVAE.repository.QualificatifRepository;
import fr.ubo.dosi.CSCIEVAE.repository.QuestionEvaluationRepository;
import fr.ubo.dosi.CSCIEVAE.repository.QuestionRepository;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseQuestionRepository;
import fr.ubo.dosi.CSCIEVAE.repository.RubriqueEvalutionRepository;
import fr.ubo.dosi.CSCIEVAE.repository.UniteEnseignementRepository;
import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling.Sort;

@Service
public class ReponseQuestionService {
	
	@Autowired
	private ReponseQuestionRepository reponseQuestionRepository;
	@Autowired
	private RubriqueEvalutionRepository rubriqueEvaluationRepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private QuestionEvaluationRepository questionEvaluationRepository;
	@Autowired
	private QualificatifRepository qualificatifRepository;
	
	
	
	public ReponseQuestion findByIdQuestionEvaluation(Long id){
		
		List<ReponseQuestion> reponseQuestions =this.reponseQuestionRepository.findAll();
		for(int i=0; i<reponseQuestions.size();i++) {
			
			Long idQuestionEvaluation = reponseQuestions.get(i).getIdQuestionEvaluation();
			//id question by idQuestionEvaluation
			QuestionEvaluation questionEvaluation= this.questionEvaluationRepository.findById(idQuestionEvaluation).get();
			
			RubriqueEvaluation rubriqueEvaluation = this.rubriqueEvaluationRepository.getById(questionEvaluation.getIdRubriqueEvaluation());
			
			if(rubriqueEvaluation.getIdEvaluation() == id) return reponseQuestions.get(i);
		}
		return null;
		
	}
	
  
    public StatReponseQuestionDTO getStatReponseQuestion(Long idQuestionEvaluation) {  
    	//service
       ReponseQuestion reponseQ = new ReponseQuestion();
    	
    	//chercher question reponse
  
       QuestionEvaluation qe = this.questionEvaluationRepository.getById(idQuestionEvaluation);    		   
    	Question q = questionRepository.getById(qe.getIdQuestion());
		
		//mapping reponsequestion dto
       StatReponseQuestionDTO rq = new StatReponseQuestionDTO();
       rq.setIdQuestion(q.getIdQuestion());
       rq.setIdQuestionEvaluation(qe.getIdQuestionEvaluation());
       rq.setIntitule(q.getIntitule());   
       Qualificatif qualificatif = this.qualificatifRepository.getById(q.getIdQualificatif());
       rq.setQualificatif(qualificatif);    
       rq.setOrder(qe.getOrdre());
       rq.setType(q.getType());
      
       rq.setNbrPos1(0);
       rq.setNbrPos2(0);
       rq.setNbrPos3(0);
       rq.setNbrPos4(0);
       rq.setNbrPos5(0);
       List<ReponseQuestion> reponseQuestions= reponseQuestionRepository.findAll();
 
       //parcourir toutes les reponses
       reponseQuestions.forEach(reponseQuestion-> {
    	   //filtrer celles qui ont le meme id question evaluation
          if(reponseQuestion.getIdQuestionEvaluation()== idQuestionEvaluation) {
        	  //incrementer selon le positionnement
        	  if(reponseQuestion.getPositionnement()== 1) rq.setNbrPos1(rq.getNbrPos1()+1);
        	  if(reponseQuestion.getPositionnement()== 2) rq.setNbrPos2(rq.getNbrPos2()+1);
        	  if(reponseQuestion.getPositionnement()== 3) rq.setNbrPos3(rq.getNbrPos3()+1);
        	  if(reponseQuestion.getPositionnement()== 4) rq.setNbrPos4(rq.getNbrPos4()+1);
        	  if(reponseQuestion.getPositionnement()== 5) rq.setNbrPos5(rq.getNbrPos5()+1);
          }
           
       });
       int max = rq.getNbrPos1();
       if(max< rq.getNbrPos2()) max= rq.getNbrPos2();
       if(max< rq.getNbrPos3()) max= rq.getNbrPos3();
       if(max< rq.getNbrPos4()) max= rq.getNbrPos4();
       if(max< rq.getNbrPos5()) max= rq.getNbrPos5();
       
       rq.setMax(max);
       int nbrEtud=rq.getNbrPos1()+rq.getNbrPos2()+rq.getNbrPos3()+rq.getNbrPos4()+rq.getNbrPos5() ;
     
       if(nbrEtud !=0) 
     rq.setMoyenne((long)((rq.getNbrPos1()
    		  +(rq.getNbrPos2()*2)
    		  +(rq.getNbrPos3()*3)
    		  +(rq.getNbrPos4()*4)
    		  +(rq.getNbrPos5()*5))
    		  /nbrEtud));
       else rq.setMoyenne((long)0);
      return rq;
    	
    }
	

}
