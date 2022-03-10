package fr.ubo.dosi.CSCIEVAE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import fr.ubo.dosi.CSCIEVAE.entity.UniteEnseignement;
import fr.ubo.dosi.CSCIEVAE.service.UniteEnseignementService;

@RestController
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
	
	//unités enseignement de la promotion dosi 2013-2014
	@GetMapping("UniteEnseignements/DOSI/2013-2014")
	public List<UniteEnseignement> ListerUniteEnseignementDosi(){
		return this.uniteEnseignementService.ListAll();
	}
	

}
