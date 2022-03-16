package fr.ubo.dosi.CSCIEVAE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

import fr.ubo.dosi.CSCIEVAE.entity.UniteEnseignement;
import fr.ubo.dosi.CSCIEVAE.service.UniteEnseignementService;

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
