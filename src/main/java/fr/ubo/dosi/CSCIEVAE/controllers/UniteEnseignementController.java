package fr.ubo.dosi.CSCIEVAE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import fr.ubo.dosi.CSCIEVAE.entity.UniteEnseignement;
import fr.ubo.dosi.CSCIEVAE.service.UniteEnseignementService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/ue")
public class UniteEnseignementController {
	@Autowired
	private UniteEnseignementService uniteEnseignementService;
	
	@PostMapping("/UniteEnseignement")
	public UniteEnseignement addUniteEnseignement(@RequestBody UniteEnseignement ue) {
		return this.uniteEnseignementService.save(ue);
	}
	
	@GetMapping("UniteEnseignements")
	public List<UniteEnseignement> ListerUniteEnseignement(){
		return this.uniteEnseignementService.ListAll();
	}
	
	@GetMapping("UniteEnseignement/{code}")
	public Map<String,String> getUeByCode(@PathVariable String code){
		return this.uniteEnseignementService.getByCodeUe(code);
	}
	
	@GetMapping("UniteEnseignements/{code}")
	public List<Map<String,String>> ListerUeByFormation(@PathVariable String code){
		return this.uniteEnseignementService.ListByCodeFormation(code);
	}
	
	

}
