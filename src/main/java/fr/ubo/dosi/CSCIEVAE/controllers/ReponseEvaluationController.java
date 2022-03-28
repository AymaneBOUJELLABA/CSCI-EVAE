package fr.ubo.dosi.CSCIEVAE.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ubo.dosi.CSCIEVAE.dto.PromotionsStatsDTO;
import fr.ubo.dosi.CSCIEVAE.dto.ReponseEvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.services.ReponseEvaluationService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Log4j2
@RequestMapping(path = "/api/evaluations/reponses")
public class ReponseEvaluationController
{
	@Autowired
	ReponseEvaluationService reponseEvaluationService;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<ReponseEvaluationDTO>> getAllReponsesEvaluations()
	{
		log.info("Recherche des Réponses de toutes les évaluations....");
		List<ReponseEvaluationDTO> result = reponseEvaluationService.getAllReponseEvaluations();
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@GetMapping("/{AnneUniv}/{CodeUe}")
	@ResponseBody
	public ResponseEntity<List<ReponseEvaluationDTO>> getAllReponsesEvaluationsByCodeUeAndAnneeUniv(
			@PathVariable("AnneUniv") String AnneUniv, 
				@PathVariable("CodeUe") String CodeUe)
	{
		log.info("Recherche des Réponse de l'evaluation de l'ue" + CodeUe + " de l'année univ : " + AnneUniv);
		List<ReponseEvaluationDTO> result = reponseEvaluationService.getAllReponseEvaluationsByUeAndAnneUniv(CodeUe, AnneUniv);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/graphes")
	@ResponseBody
	public ResponseEntity<List<PromotionsStatsDTO>> getAllPromotionsForGraphes()
	{
		log.info("Recherche des informations pour affichage des graphes");
		List<PromotionsStatsDTO> result = reponseEvaluationService.getAllPromotionsGraphesData();
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	
}
