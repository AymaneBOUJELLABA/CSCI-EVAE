package fr.ubo.dosi.CSCIEVAE.controllers;

import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.enstities.Evaluation;
import fr.ubo.dosi.CSCIEVAE.enstities.Rubrique;
import fr.ubo.dosi.CSCIEVAE.exceptions.EvaluationNotfoundException;
import fr.ubo.dosi.CSCIEVAE.services.EvaluationService;
import fr.ubo.dosi.CSCIEVAE.utils.DataMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/evaluations")
@Log4j2
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private DataMapper dataMapper;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Evaluation>> getAllEvalutions(){
        log.info("Recherche sur toutes les évalutions");
        return new ResponseEntity<>(
                evaluationService.getAllEvalutions(),
                HttpStatus.FOUND);
    }

    @GetMapping("/ue")
    @ResponseBody
    public ResponseEntity<EvaluationDTO> getEvationByCodeUE(@RequestParam String codeUe){
        Evaluation evaluation = evaluationService.getEvalutionParCodeUe(codeUe);
        if (evaluation == null) {
            log.error("Evalution not found pour l'UE "+codeUe);
            throw new EvaluationNotfoundException();
        } else {
            EvaluationDTO evaluationDTO = dataMapper.evaluationMapperToDTO(evaluation);
            evaluationDTO.setRubriques(evaluationService.getRubriqueEvaluation(evaluation.getIdEvaluation()));
            log.info("Recherche de l'évaluation de l'UE :" + codeUe);
            return new ResponseEntity<>(
                    evaluationDTO,
                    HttpStatus.FOUND);
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<EvaluationDTO> getEvaluationDetails(@PathVariable int id){

        Evaluation evaluation = evaluationService.getEvalutionParId((long) id);
        if (evaluation == null){
            log.error("Evalution not found pour ID "+id);
            throw new EvaluationNotfoundException();
        }else{
            EvaluationDTO evaluationDTO = dataMapper.evaluationMapperToDTO(evaluation);
            evaluationDTO.setRubriques(evaluationService.getRubriqueEvaluation(evaluation.getIdEvaluation()));
            log.info("Recherche de l'évaluation avec ID :" + id);
            return new ResponseEntity<>(
                    evaluationDTO,
                    HttpStatus.FOUND);
        }
    }

    @GetMapping("/rubriques")
    @ResponseBody
    public ResponseEntity<List<Rubrique>> getAllRubriquesForEvaluationCreation(){
        return new ResponseEntity<>(
                evaluationService.getRubriquesForEvaluationCreation(),
                HttpStatus.ACCEPTED);
    }

}
