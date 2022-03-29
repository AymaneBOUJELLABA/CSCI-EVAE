package fr.ubo.dosi.CSCIEVAE.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ubo.dosi.CSCIEVAE.dto.EtudiantDTO;
import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.PromotionsStatsDTO;
import fr.ubo.dosi.CSCIEVAE.dto.QuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.QuestionReponseInfoDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseEvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseEvaluationGraphesDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseQuestionDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseRubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.dto.RubriqueGraphesDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Etudiant;
import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import fr.ubo.dosi.CSCIEVAE.entity.Promotion;
import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;
import fr.ubo.dosi.CSCIEVAE.entity.QuestionEvaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseQuestion;
import fr.ubo.dosi.CSCIEVAE.entity.Rubrique;
import fr.ubo.dosi.CSCIEVAE.entity.RubriqueEvaluation;
import fr.ubo.dosi.CSCIEVAE.messages.EvaluationReponseInMessage;
import fr.ubo.dosi.CSCIEVAE.repository.EtudiantRepository;
import fr.ubo.dosi.CSCIEVAE.repository.PromotionRepository;
import fr.ubo.dosi.CSCIEVAE.repository.QualificatifRepository;
import fr.ubo.dosi.CSCIEVAE.repository.QuestionEvaluationRepository;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseEvaluationRepository;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseQuestionRepository;
import fr.ubo.dosi.CSCIEVAE.repository.RubriqueEvalutionRepository;
import fr.ubo.dosi.CSCIEVAE.utils.DataMapper;
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
	@Autowired
	RubriqueService rubriqueService;
	@Autowired
	QualificatifRepository qualifRepo;
	@Autowired
	RubriqueEvalutionRepository rubriqueEvaluationrepo;
	@Autowired
	QuestionEvaluationRepository questEvalRepo;
	
	@Override
	public List<ReponseEvaluationDTO> getAllReponseEvaluations()
	{
		try
		{
			List<ReponseEvaluation> rDB = reponseEvalRepo.findAll();
			log.info("____Number of ReponseEvals____"+rDB.size());
			List<ReponseEvaluationDTO> r = new ArrayList<ReponseEvaluationDTO>();
			
			for(ReponseEvaluation i : rDB)
			{				
				ReponseEvaluationDTO n = this.populateDTOfromReponseEvaluation(i);
				r.add(n);
			}	
			return r;
			
		}catch(Exception e)
		{
			log.error("___ERROR get all reponse evaluations",e);
			return null;
		}
	}

	@Override
	public List<ReponseEvaluationDTO> getAllReponseEvaluationsByUeAndAnneUniv(String codeUe,String anneeUniv)
	{
		try
		{
			List<ReponseEvaluation> repsEval = reponseEvalRepo.findAllByCodeUeAndAnneUniv(codeUe, anneeUniv);
			List<ReponseEvaluationDTO> output = repsEval.stream().map(rep -> 
				this.populateDTOfromReponseEvaluation(rep)
			).collect(Collectors.toList());
			
			return output;
		}catch(Exception e)
		{
			log.error("___Erreur get All reponse evaluation By UE __ =>" + e);
		}
		return null;
	}

	@Override
	public ReponseEvaluationDTO addReponseEvaluation(EvaluationReponseInMessage entity) throws Exception
	{
		///SAVE INTO REPONSE_EVALUATION
		//THEN -> REPONSE_QUESTION
			log.info("---input : " + entity.getIdEtudiant() + " | " + entity.getIdEvaluation());
			ReponseEvaluationDTO result = new ReponseEvaluationDTO();
			
			if(etudiantRepo.findById(entity.getIdEtudiant()).isPresent())
			{
				throw new Exception("Numero d'étudiant invalide!");
			}
			
			Etudiant etd = etudiantRepo.findById(entity.getIdEtudiant()).get();
			log.info("___Etudiant :" + etd);
			
			
			Evaluation eval = evaluationService.getEvalutionParId(entity.getIdEvaluation());
			if(eval == null)
			{
				throw new Exception("Erreur lors de la recherche de l'evaluation "+entity.getIdEvaluation());
			}
			log.info("__Evaluation :" + eval);
			
			ReponseEvaluation RepEval = reponseEvalRepo.findByIdEvaluationAndNoEtudiant(eval.getIdEvaluation(), etd.getNoEtudiant());

			if(RepEval != null && RepEval.getIdReponseEvaluation() !=null)
			{
				log.error("___Etudiant a déjà rempli le questionnaire de cette evaluation");
				throw new Exception("Etudiant à dèja remplie ce questionnaire!");
			}else
			{
				log.info("__ajout d'une nouvelle réponse pour l'etudiant " + etd.getNoEtudiant() + " pour l'évaluation : " + eval.getIdEvaluation());
				RepEval = new ReponseEvaluation();
				RepEval.setIdEvaluation(eval.getIdEvaluation());
				RepEval.setIdReponseEvaluation(null);
				RepEval.setCommentaire(entity.getCommentaire());
				RepEval.setNoEtudiant(etd.getNoEtudiant());
				RepEval.setNom(etd.getNom());
				RepEval.setPrenom(etd.getPrenom());
				log.info("__Nouvelle reponse Evaluation : " + RepEval);
				try
				{
					RepEval = reponseEvalRepo.save(RepEval);
				}catch(Exception e)
				{
					throw new Exception("Erreur lors de l'ajout de la nouvelle reponse evaluation => cause: " +e.getMessage());
				}
				
				log.info("__Ajout d'une nouvelle reponse evaluation avec succes!" + RepEval);
			}
			
			log.info("__Début de l'ajout des question réponse....");
			log.info("___Getting all rubriques réponses....");
			List<ReponseRubriqueDTO> repRubs = entity.getRubriques().stream().map(rub ->
			{
				ReponseRubriqueDTO r = new ReponseRubriqueDTO();
				RubriqueEvaluation rubEval = rubriqueEvaluationrepo.findByIdEvaluationAndIdRubrique(eval.getIdEvaluation(), rub.getIdRubrique());
				

				List<ReponseQuestionDTO> repQst = rub.getQuestions().stream().map(repQ ->
				{
					ReponseEvaluation rEval = reponseEvalRepo.findByIdEvaluationAndNoEtudiant(eval.getIdEvaluation(), etd.getNoEtudiant());
					ReponseQuestionDTO nQ = new ReponseQuestionDTO();
					ReponseQuestion Q2S = new ReponseQuestion();
					QuestionEvaluation QEval = questEvalRepo.findByIdQuestionAndIdRubriqueEvaluation(repQ.getIdQuestion(), rubEval.getIdRubriqueEvaluation());
					
					//enregistrer la nouvelle Réponse Question
					Q2S.setIdQuestionEvaluation(QEval.getIdQuestionEvaluation());
					Q2S.setIdReponseEvaluation(rEval.getIdReponseEvaluation());
					Q2S.setPositionnement(repQ.getReponse());
					Q2S = reponseQuestionRepository.save(Q2S);
					
					
					//Récupérer les infos nécessaire pour populer la sortie
					nQ.setIdQuestionEvaluation(Q2S.getIdQuestionEvaluation());
					nQ.setIdReponseEvaluation(Q2S.getIdReponseEvaluation());
					nQ.setPositionnement(Q2S.getPositionnement());
					
					nQ.setQuestion(new QuestionDTO(
								QEval.getIdQuestion(),
								repQ.getType(), 
								repQ.getNoEnseignant(), 
								repQ.getIntitule(), 
								QEval.getOrdre(), 
								repQ.getQualificatif()));
					return nQ;
				}).collect(Collectors.toList());
				
				r.setIdRubriqueEvaluation(rubEval.getIdRubriqueEvaluation());
				r.setQuestions(repQst);
				r.setRubriqueinfo(rubriqueService.getRubriqueByDesignation(rub.getDesignation()));
				return r;
			}).collect(Collectors.toList());
			
		
			result.setCommentaire(entity.getCommentaire());
			result.setEtudiant(etd);
			result.setEvaluation(mapper.evaluationMapperToDTO(eval));
			result.setIdReponseEvaluation(RepEval.getIdReponseEvaluation());
			result.setRubriques(repRubs);
			
			log.info("_____Opération términé! resultat : ", result);
			return result;
	}

	@Override
	public Etudiant getEtudiantFromResponseEvaluation(Long idReponseEvaluation)
	{
		try
		{
			log.info("__Chercher l'etudiant liée à l'id réponse evaluation  :"+idReponseEvaluation+" ___");
			Etudiant etd = etudiantRepo.findByReponseEvaluation(idReponseEvaluation);
			log.info("__Etudiant trouvé : " + etd);
			return etd;
		}catch(Exception e)
		{
			log.error("__Impossible de trouver l'etudiant =>" + e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<QuestionReponseInfoDTO> getQuestionReponseAllInfo(Long idReponseEvaluation)
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
							.positionnement(((BigDecimal) item[5]).longValue())
							.noEtudiant(((String) item[6]))
							.idReponseEvaluation(((BigDecimal) item[7]).longValue())
							.idRubriqueEvaluation(((BigDecimal) item[8]).longValue())
							.idQuestionEvaluation(((BigDecimal) item[9]).longValue())
							.ordre(((BigDecimal) item[10]).longValue())
							.build();
				result.add(i);
			});
			
			return result;
			
		}catch(Exception e)
		{
			log.error("____ERREUR!! getQuestionAllInfo=>"+e);
			return null;
		}
		
	}

	@Override
	public ReponseEvaluationDTO populateDTOfromReponseEvaluation(ReponseEvaluation repEval)
	{
		try
		{
			ReponseEvaluationDTO item = new ReponseEvaluationDTO();
			Etudiant etd = this.getEtudiantFromResponseEvaluation(repEval.getIdReponseEvaluation());
			Evaluation eval = evaluationService.getEvalutionParId(repEval.getIdEvaluation());
			
			
			List<QuestionReponseInfoDTO> rQuestions = this.getQuestionReponseAllInfo(repEval.getIdReponseEvaluation());
			List<ReponseRubriqueDTO> rubriques = new ArrayList<ReponseRubriqueDTO>();
			
			log.info("___Associations des rubriques avec les réponses Questions.....");
			rQuestions.forEach(question->
			{
				boolean rubExists = false;
				for(ReponseRubriqueDTO j : rubriques)
				{
					if(j.getIdRubriqueEvaluation().equals(question.getIdRubriqueEvaluation()))
					{
						rubExists = true;
					}
				}
				
				ReponseRubriqueDTO rub = rubriques.stream()
											.filter(el -> el.getIdRubriqueEvaluation().equals(question.getIdRubriqueEvaluation()))
											.findFirst()
											.orElse(new ReponseRubriqueDTO());
				
				//if rub exists
				List<ReponseQuestionDTO> rubQsts = rubExists ? rub.getQuestions() : new ArrayList<ReponseQuestionDTO>();
				
				//add question to rub
				QuestionDTO qDTO = new QuestionDTO();
				qDTO.setIdQuestion(question.getIdQuestion());
				qDTO.setIntitule(question.getIntitule());
				qDTO.setNoEnseignant(
						question.getNoEnseignant() == null || question.getNoEnseignant().isEmpty() ? null:
						Long.parseLong(question.getNoEnseignant()));
				qDTO.setOrder(question.getOrdre());
				if(qualifRepo.findById(question.getIdQualificatif()).isPresent())
					qDTO.setQualificatif(qualifRepo.findById(question.getIdQualificatif()).get());
				qDTO.setType(question.getType());
				rubQsts.add(
						new ReponseQuestionDTO(
								question.getIdQuestionEvaluation(),
								question.getIdReponseEvaluation(),
								question.getPositionnement(),
								qDTO)
						);
				
				rub.setQuestions(rubQsts);
				
				if(!rubExists)
				{
					Rubrique rubInfo = rubriqueService.getRubriqueByIdRubriqueEvaluation(question.getIdRubriqueEvaluation()); //RubriqueInfo
					System.out.println("RUB INFO : " + rubInfo);
					rub.setRubriqueinfo(rubInfo);
					rub.setIdRubriqueEvaluation(question.getIdRubriqueEvaluation());
					rubriques.add(rub);
				}else
				{
					int  i =rubriques.indexOf(rub);
					rubriques.set(i, rub);
				}
				
				
			});
			
			item.setEtudiant(etd);
			item.setEvaluation(mapper.evaluationMapperToDTO(eval));
			item.setIdReponseEvaluation(repEval.getIdReponseEvaluation());
			item.setCommentaire(repEval.getCommentaire());
			item.setRubriques(rubriques);
			log.info("____Opération términé avec succes!! resultat : \n" + item);
			return item;
		}catch(Exception e)
		{
			log.error("__ERROR while populating for Reponse Evaluation DTO____ => "+e);
			return null;
		}
		
	}

	@Override
	public EvaluationDTO getEvaluationFromResponseEvaluation(Long idReponseEvaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReponseQuestion> getAllQuestionReponseByIdReponseEvaluation(Long idReponseEvaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Autowired
	PromotionRepository promoRepo;
	@Override
	//GET ALL PROMOS -> GET ALL EVALUATIONS REPONSES OF PROMO -> CALCULER MOY FOR EACH EVAL
	public List<PromotionsStatsDTO> getAllPromotionsGraphesData()
	{
		try
		{
			log.info("----Chercher tous les promos....");
			//chercher tous les promos
			List<Promotion> dbPromos = promoRepo.findAll();

			log.info("---chercher les réponse des evaluations");
			
			//mapper les promos en PromotionsStatsDTO
			List<PromotionsStatsDTO> result = dbPromos.stream().map(promo ->
			{
				//chercher tous les evaluations
				List<ReponseEvaluationDTO> repEvals = this.getAllReponseEvaluationsByAnneUnivAndCodeFormation(promo.getAnneeUniversitaire(), promo.getCodeFormation());
				
				PromotionsStatsDTO newP = new PromotionsStatsDTO();
				//mapper les evaluations en reponseEvaluationsGraphesDTO
				List<ReponseEvaluationGraphesDTO> gEvals = repEvals.stream().map(eval->
				{
					ReponseEvaluationGraphesDTO r = new ReponseEvaluationGraphesDTO();
					
					r.setCodeUe(eval.getEvaluation().getCodeUe());
					r.setRubriques(this.calculerMoyenneRub(eval.getRubriques()));
					return r;
				}).collect(Collectors.toList());
				
				newP.setAnneUniv(promo.getAnneeUniversitaire());
				newP.setCodeFormation(promo.getCodeFormation());
				newP.setReponseEvaluations(gEvals);
				return newP;
			}).collect(Collectors.toList());
			return result;
			
		}catch(Exception e)
		{
			log.error("___ ERROR GETTING ALL RESPONSES EVALUATION FOR GRAPHES____ => "+ e);
			return null;
		}
	}
	
	public List<RubriqueGraphesDTO> calculerMoyenneRub(List<ReponseRubriqueDTO> rubriques)
	{
		try
		{
			log.info("---Calculer la moyenne pour chaque Rubrique---");
			List<RubriqueGraphesDTO> rubG = rubriques.stream().map(rub ->
			{
				Double sum = 0d;
				for(ReponseQuestionDTO q : rub.getQuestions())
				{
					sum += q.getPositionnement();
				}
				
				RubriqueGraphesDTO r = new RubriqueGraphesDTO(rub.getRubriqueinfo().getDesignation(),sum/rub.getQuestions().size());				
				
				log.info("----Rubrique Graphe : "+ r);
				return r;
			}).collect(Collectors.toList());
			
			return rubG;
			
		}catch(Exception e)
		{
			log.error("___ERROR calculer moyenne Rubriques ... => " + e);
			return null;
		}
		
	}

	@Override
	public List<ReponseEvaluationDTO> getAllReponseEvaluationsByAnneUnivAndCodeFormation(String anneeUniv,String codeFormation)
	{
		try
		{
			List<ReponseEvaluation> repsEval = reponseEvalRepo.findAllByAnneeUnivAndCodeFormation(anneeUniv,codeFormation);
			List<ReponseEvaluationDTO> output = repsEval.stream().map(rep -> 
				this.populateDTOfromReponseEvaluation(rep)
			).collect(Collectors.toList());
			
			return output;
		}catch(Exception e)
		{
			log.error("___Erreur get All reponse evaluation By CodeFormation And anneUniv  __ =>" + e);
		}
		return null;
	}
}
