package fr.ubo.dosi.CSCIEVAE.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ubo.dosi.CSCIEVAE.dto.EtudiantDTO;
import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseEvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import fr.ubo.dosi.CSCIEVAE.entity.ReponseEvaluation;
import fr.ubo.dosi.CSCIEVAE.repository.EtudiantRepository;
import fr.ubo.dosi.CSCIEVAE.repository.ReponseEvaluationRepository;
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

	@Override
	public List<ReponseEvaluationDTO> getAllReponseEvaluations()
	{
		List<ReponseEvaluation> rDB = reponseEvalRepo.findAll();
		List<ReponseEvaluationDTO> r = new ArrayList<ReponseEvaluationDTO>();
		
		for(ReponseEvaluation i : rDB)
		{
			EtudiantDTO etd = this.getEtudiantFromResponseEvaluation(i.getIdReponseEvaluation());
			
			
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
	public EtudiantDTO getEtudiantFromResponseEvaluation(Long idReponseEvaluation)
	{
		
		Etudiant e = etudiantRepo.findByReponseEvaluation(idReponseEvaluation);
		log.info("__Chercher l'etudiant liée à l'id réponse evaluation  :"+idReponseEvaluation+" ___");
		
	}
}
