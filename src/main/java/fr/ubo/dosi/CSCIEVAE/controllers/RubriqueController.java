package fr.ubo.dosi.CSCIEVAE.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ubo.dosi.CSCIEVAE.dto.RubriqueDTO;
import fr.ubo.dosi.CSCIEVAE.enstities.Rubrique;
import fr.ubo.dosi.CSCIEVAE.services.RubriqueService;

@RestController
@RequestMapping("/api/rubriques")
public class RubriqueController
{
	private static Logger logger = LogManager.getLogger(RubriqueController.class);
	
	@Autowired
	RubriqueService rubriqueService;
	
	@GetMapping
	public List<RubriqueDTO> getAllRubriques()
	{
		try
		{
			List<Rubrique> r = rubriqueService.listdesRubriques();
			return r;
		}catch(Exception e)
		{
			logger.error("Error : "+e);
		}
		return null;
	}
	
	@PostMapping
	public ResponseEntity<Rubrique> addRubrique(@RequestBody Rubrique entity)
	{
		try
		{
			Rubrique r =rubriqueService.ajouterRubrique(entity);
			return new ResponseEntity<>(r,HttpStatus.OK);
		}catch(Exception e)
		{
			logger.error(e);
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/all")
	public ResponseEntity<List<Rubrique>> updateAllRubriques(@RequestBody List<Rubrique> list)
	{
		try 
		{
			List<Rubrique> r = rubriqueService.ajouterAllRubriques(list);
			return new ResponseEntity<>(r,HttpStatus.OK);
			
		}catch(Exception e)
		{
			logger.error(e);
			return new ResponseEntity<>(new ArrayList<Rubrique>(),HttpStatus.OK);
		}
	}
}
