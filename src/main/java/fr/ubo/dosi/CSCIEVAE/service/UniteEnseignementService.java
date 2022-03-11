package fr.ubo.dosi.CSCIEVAE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;

import fr.ubo.dosi.CSCIEVAE.entity.Enseignant;
import fr.ubo.dosi.CSCIEVAE.entity.UniteEnseignement;
import fr.ubo.dosi.CSCIEVAE.repository.EnseignantRepository;
import fr.ubo.dosi.CSCIEVAE.repository.UniteEnseignementRepository;

@Service
public class UniteEnseignementService {
	
	@Autowired
	private UniteEnseignementRepository uniteEnseignementRepository;
	@Autowired
	private EnseignantRepository enseignantRepository;
	
	public UniteEnseignement save(UniteEnseignement uniteEnseignement) {
		return this.uniteEnseignementRepository.save(uniteEnseignement);
	}
	
	public List<UniteEnseignement>saveAll(List<UniteEnseignement> unites){
		return this.uniteEnseignementRepository.saveAll(unites);
	}
	
	public List<UniteEnseignement> ListAll(){
		return this.uniteEnseignementRepository.findAll();
	}
	
	public List<Map<String,String>> ListByCodeFormation(String codeFormation){
		List<UniteEnseignement> unites = this.ListAll();
		
		List<Map<String,String>>ListUe = new ArrayList<Map<String,String>>();
		Enseignant e;
	
		//UniteEnseignement ue = new UniteEnseignement();
		for(int i=0; i<unites.size(); i++) {
			if(unites.get(i).getCodeFormation().equals(codeFormation)) {
				//unites.add(unites.get(i));
				Map<String,String> ue = new HashMap<String,String>();
				ue.put("codeUe", unites.get(i).getCodeUe());
			    ue.put("designation", unites.get(i).getDesignation());
				e = this.enseignantRepository.findByNoEnseignant(unites.get(i).getNoEnseignant());
				ue.put("nom", e.getNom());
				ue.put("prenom",e.getPrenom());
				ListUe.add(ue);
			}
		}
		return ListUe;
	}
	

	
	public Map<String,String> getByCodeUe(String code) {
		List<UniteEnseignement> unites = this.ListAll();
		Map<String,String> ue = new HashMap<String,String>();
		Enseignant e;
		for(int i=0; i<unites.size(); i++) {
			if(unites.get(i).getCodeUe().equals(code)) {
				ue.put("codeUe", unites.get(i).getCodeUe());
			    ue.put("designation", unites.get(i).getDesignation());
			    ue.put("semestre", unites.get(i).getSemestre());
			    ue.put("description", unites.get(i).getDescription());
			    ue.put("nbhCm", unites.get(i).getNbhCm().toString());
			    ue.put("nbhTd", unites.get(i).getNbhTd().toString());
			    ue.put("nbhTp", unites.get(i).getNbhTp().toString());
			    ue.put("nbhTp", unites.get(i).getNbhTp().toString());
				e = this.enseignantRepository.findByNoEnseignant(unites.get(i).getNoEnseignant());
				ue.put("nomEnseigant",e.getNom() );
				ue.put("prenomEnseignant",e.getPrenom());
				ue.put("typeEnseignant",e.getType());
				ue.put("emailUbo",e.getEmailUbo());
				ue.put("emailPerso",e.getEmailPerso());
				ue.put("mobile",e.getMobile());
				return ue;
				
			}
		}
		return ue;
		
	}

}
