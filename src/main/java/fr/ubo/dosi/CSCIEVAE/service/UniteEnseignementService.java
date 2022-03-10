package fr.ubo.dosi.CSCIEVAE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import fr.ubo.dosi.CSCIEVAE.entity.UniteEnseignement;
import fr.ubo.dosi.CSCIEVAE.repository.UniteEnseignementRepository;

@Service
public class UniteEnseignementService {
	
	@Autowired
	private UniteEnseignementRepository uniteEnseignementRepository;
	
	public UniteEnseignement save(UniteEnseignement uniteEnseignement) {
		return this.uniteEnseignementRepository.save(uniteEnseignement);
	}
	
	public List<UniteEnseignement>saveAll(List<UniteEnseignement> unites){
		return this.uniteEnseignementRepository.saveAll(unites);
	}
	
	public List<UniteEnseignement> ListAll(){
		return this.uniteEnseignementRepository.findAll();
	}
	
	public List<UniteEnseignement> ListUeDosi(){
		List<UniteEnseignement> unites = new ArrayList<UniteEnseignement>() ;
		UniteEnseignement ue = new UniteEnseignement();
		for(int i=0; i<unites.size(); i++) {
			if(unites.get(i).getCodeUe().equals("M2DOSI")) 
				unites.add(unites.get(i));
		}
		return unites;
	}
	
	public UniteEnseignement getByCodeUe(String code) {
		List<UniteEnseignement> unites = this.ListAll();
		UniteEnseignement ue = new UniteEnseignement();
		for(int i=0; i<unites.size(); i++) {
			if(unites.get(i).getCodeUe().equals(code)) return unites.get(i);
		}
		return ue;
	}

}
