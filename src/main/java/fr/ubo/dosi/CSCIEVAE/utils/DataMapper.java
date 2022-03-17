package fr.ubo.dosi.CSCIEVAE.utils;

import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.dto.UniteEnseignementDTO;
import fr.ubo.dosi.CSCIEVAE.entity.Enseignant;
import fr.ubo.dosi.CSCIEVAE.entity.Evaluation;
import fr.ubo.dosi.CSCIEVAE.entity.UniteEnseignement;
import fr.ubo.dosi.CSCIEVAE.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class DataMapper {
	


    public EvaluationDTO evaluationMapperToDTO(Evaluation eva){
        EvaluationDTO evaDto = new EvaluationDTO();
        evaDto.setAnneeUniversitaire(eva.getAnneeUniversitaire());
        evaDto.setCodeEc(eva.getCodeEc());
        evaDto.setCodeFormation(eva.getCodeFormation());
        evaDto.setCodeUe(eva.getCodeUe());
        evaDto.setDebutReponse(eva.getDebutReponse());
        evaDto.setDesignation(eva.getDesignation());
        evaDto.setEtat(eva.getEtat());
        evaDto.setFinReponse(eva.getFinReponse());
        evaDto.setIdEvaluation(eva.getIdEvaluation());
        evaDto.setNoEnseignant(eva.getNoEnseignant());
        evaDto.setNoEvaluation(eva.getNoEvaluation());
        evaDto.setPeriode(eva.getPeriode());
        return evaDto;
    }

    public Evaluation evaluationDtoToEvaluation(EvaluationDTO evaluationDTO){
    	
        Evaluation eva = new Evaluation();
        eva.setIdEvaluation(evaluationDTO.getIdEvaluation());
        eva.setNoEvaluation(evaluationDTO.getNoEvaluation());
        eva.setAnneeUniversitaire(evaluationDTO.getAnneeUniversitaire());
        eva.setCodeEc(evaluationDTO.getCodeEc());
        eva.setCodeFormation(evaluationDTO.getCodeFormation());
        eva.setCodeUe(evaluationDTO.getCodeUe());
        eva.setDebutReponse(evaluationDTO.getDebutReponse());
        eva.setDesignation(evaluationDTO.getDesignation());
        eva.setEtat(evaluationDTO.getEtat());
        eva.setFinReponse(evaluationDTO.getFinReponse());
        eva.setNoEnseignant(evaluationDTO.getNoEnseignant());
        eva.setPeriode(evaluationDTO.getPeriode());
        return eva;
    }

}
