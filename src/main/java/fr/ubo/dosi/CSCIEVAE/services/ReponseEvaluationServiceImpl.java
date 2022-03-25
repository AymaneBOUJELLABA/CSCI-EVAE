package fr.ubo.dosi.CSCIEVAE.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ubo.dosi.CSCIEVAE.dto.EtudiantDTO;
import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.QuestionReponseInfoDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseEvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Etudiant;
import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestion;
import fr.ubo.dosi.CSCIEVAE.repository.EtudiantRepository;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseEvaluationRepository;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseQuestionRepository;
import fr.ubo.dosi.CSCIEVAE.utils.DataMapper;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ReponseEvaluationServiceImpl implements ReponseEvaluationService
{
	
	private static DataMapper mapper = new DataMapper();
	
	@Autowired
	ReponseEvaluationRepository reponseEvalRepo;
	@Autowired
	EvaluationService evaluationService;
	@Autowired
	EtudiantRepository etudiantRepo;
	@Autowired
	ReponseQuestionRepository reponseQuestionRepository;

	@Override
	public List<ReponseEvaluationDTO> getAllReponseEvaluations()
	{
		List<ReponseEvaluation> rDB = reponseEvalRepo.findAll();
		List<ReponseEvaluationDTO> r = new ArrayList<ReponseEvaluationDTO>();
		
		for(ReponseEvaluation i : rDB)
		{
			ReponseEvaluationDTO item = new ReponseEvaluationDTO();
			Etudiant etd = this.getEtudiantFromResponseEvaluation(i.getIdReponseEvaluation());
			Evaluation eval = evaluationService.getEvalutionParId(i.getIdEvaluation());
			
			
			
			
			item.setEtudiant(etd);
			item.setEvaluation(mapper.evaluationMapperToDTO(eval));
			item.setIdReponseEvaluation(i.getIdReponseEvaluation());
			item.setRubriques(null);
		}
		
		return null;
	}

	@Override
	public List<ReponseEvaluationDTO> getAllReponseEvaluationsByUe(String codeUe,String anneeUniv)
	{
		Evaluation eval = evaluationService.getEvalutionParCodeUeAndAnneeUniv(codeUe,anneeUniv);
		
		return null;
	}

	@Override
	public ReponseEvaluationDTO addReponseEvaluation(ReponseEvaluation entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EvaluationDTO getEvaluationFromResponseEvaluation(Long idReponseEvaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant getEtudiantFromResponseEvaluation(Long idReponseEvaluation)
	{
		try {
			log.info("__Chercher l'etudiant liée à l'id réponse evaluation  :"+idReponseEvaluation+" ___");
			Etudiant e = etudiantRepo.findByReponseEvaluation(idReponseEvaluation);
			log.info("__Etudiant trouvé : " + e);
			return e;
		}catch(Exception e)
		{
			log.error("__Impossible de trouver l'etudiant =>" + e.getMessage());
			return null;
		}
	}

	@Override
	public List<ReponseQuestion> getAllQuestionReponseByIdReponseEvaluation(Long idReponseEvaluation)
	{
		try
		{
			log.info("__Chercher les question d'un Reponse evaluations id: ("+idReponseEvaluation+" ).....");
			
			return null;
		}catch(Exception e)
		{
			log.error("__Impossible de trouver Question Reponse de cette Reponse evaluation => "+e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<QuestionReponseInfoDTO> getQuestionReponseAllInfo(Integer idReponseEvaluation)
	{
		try
		{
			System.out.println("-------------- GETTING QUESTION RESPONSES OF EVALUATION");
			List<Object[]> r = reponseQuestionRepository.findAllReponseQuestionInfo(idReponseEvaluation);
			
			List<QuestionReponseInfoDTO> result = new ArrayList<QuestionReponseInfoDTO>();
			r.forEach(item->
			{
				QuestionReponseInfoDTO i = QuestionReponseInfoDTO.builder()
							.idQuestion(((BigDecimal) item[0]).longValue())
							.type((String) item[1])
							.noEnseignant((String) item[2])
							.idQualificatif(((BigDecimal) item[3]).longValue())
							.intitule((String) item[4])
							.positionnement(((BigDecimal) item[5]).intValue())
							.noEtudiant(((String) item[6]))
							.idReponseEvaluation(((BigDecimal) item[7]).longValue())
							.idRubriqueEvaluation(((BigDecimal) item[8]).longValue())
							.build();
				result.add(i);
			});
			
			return result;
			
		}catch(Exception e)
		{
			log.error("____ERREUR!! get=>");
			return null;
		}
		
	}
}
