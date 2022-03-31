package fr.ubo.dosi.CSCIEVAE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import fr.ubo.dosi.CSCIEVAE.entity.UniteEnseignement;
import fr.ubo.dosi.CSCIEVAE.exceptions.UeNotFoundException;
import fr.ubo.dosi.CSCIEVAE.services.UniteEnseignementService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ue")
public class UniteEnseignementController {
	@Autowired
	private UniteEnseignementService uniteEnseignementService;
	
	@PostMapping
	public UniteEnseignement addUniteEnseignement(@RequestBody UniteEnseignement ue) {
		return this.uniteEnseignementService.save(ue);
	}
	
	@GetMapping
	public List<UniteEnseignement> ListerUniteEnseignement(){
		return this.uniteEnseignementService.ListAll();
	}
	
	@GetMapping("{code}")
	 public ResponseEntity<Map<String,String>> getEvationByCodeUE(@PathVariable String code){
		Map<String,String> ue = this.uniteEnseignementService.getByCodeUe(code);
	        if (ue == null) {
	            throw new UeNotFoundException();
	        } else {
	       
	            return new ResponseEntity<>(
	                    ue,
	                    HttpStatus.FOUND);
	        }
	    }

	

	
	@GetMapping("list/{code}")

	public ResponseEntity<List<Map<String,String>>> ListerUeByFormation(@PathVariable String code){
		
		return new ResponseEntity<>(
				this.uniteEnseignementService.ListByCodeFormation(code),
                HttpStatus.FOUND);
	}
	
	

}
