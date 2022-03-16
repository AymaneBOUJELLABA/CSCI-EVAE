package fr.ubo.dosi.CSCIEVAE.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Rubrique;
import fr.ubo.dosi.CSCIEVAE.messages.RubriqueOrdreUpdateMessage;
import fr.ubo.dosi.CSCIEVAE.services.RubriqueService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/rubriques")
public class RubriqueController
{
	private static Logger logger = LogManager.getLogger(RubriqueController.class);
	
	@Autowired
	RubriqueService rubriqueService;
	
	@GetMapping
	public ResponseEntity<Object> getAllRubriques()
	{
		try
		{
			List<RubriqueDTO> r = rubriqueService.listdesRubriques();
			return new ResponseEntity<>(r,HttpStatus.OK);
		}catch(Exception e)
		{
			logger.error("Error : "+e);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> addRubrique(@RequestBody Rubrique entity)
	{
		try
		{
			if(entity.getOrdre() == null || entity.getOrdre()<0)
			{
				logger.warn("Aucun ordre saisie!! --- affectation du l'ordre maximale");
				entity.setOrdre(rubriqueService.chercherMaxOrdre()+1);
			}
			RubriqueDTO r = rubriqueService.ajouterRubrique(entity);
			return new ResponseEntity<>(r,HttpStatus.OK);
		}catch(Exception e)
		{
			logger.error(e);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateOrdre")
	public ResponseEntity<Object> updateAllRubriques(@RequestBody List<RubriqueOrdreUpdateMessage> list)
	{
		try 
		{
			
			List<RubriqueDTO> r = rubriqueService.modifierOrdreRubrique(list);
			return new ResponseEntity<>(r,HttpStatus.OK);
			
		}catch(Exception e)
		{
			logger.error(e);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/AddOrUpdate")
	public ResponseEntity<Object> AddorUpdateAllRubriques(@RequestBody List<Rubrique> list)
	{
		try 
		{
			for(Rubrique r: list)
			{
				System.out.println("id : "+ r.getIdRubrique() + " designation :" +r.getDesignation());
			}
			List<RubriqueDTO> r = rubriqueService.ajouterOrUpdateAllRubriques(list);
			return new ResponseEntity<>(r,HttpStatus.OK);
			
		}catch(Exception e)
		{
			logger.error(e);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
