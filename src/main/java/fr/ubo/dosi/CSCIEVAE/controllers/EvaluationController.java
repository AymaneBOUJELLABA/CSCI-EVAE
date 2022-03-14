package fr.ubo.dosi.CSCIEVAE.controllers;

import fr.ubo.dosi.CSCIEVAE.dto.EvaluationDTO;
import fr.ubo.dosi.CSCIEVAE.enstities.Evaluation;
import fr.ubo.dosi.CSCIEVAE.exceptions.EvaluationNotfoundException;
import fr.ubo.dosi.CSCIEVAE.services.EvaluationService;
import fr.ubo.dosi.CSCIEVAE.utils.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private DataMapper dataMapper;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Evaluation>> getAllEvalutions(){
        return new ResponseEntity<>(
                evaluationService.getAllEvalutions(),
                HttpStatus.FOUND);
    }

    @GetMapping("/ue")
    @ResponseBody
    public ResponseEntity<Evaluation> getEvationByCodeUE(@RequestParam String codeUe){
        Evaluation evaluation = evaluationService.getEvalutionParCodeUe(codeUe);
        if (evaluation == null)
            throw new EvaluationNotfoundException();
        else return new ResponseEntity<>(
                evaluationService.getEvalutionParCodeUe(codeUe),
                HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<EvaluationDTO> getEvaluationDetails(@PathVariable int id){

        Evaluation evaluation = evaluationService.getEvalutionParId((long) id);
        if (evaluation == null){
            throw new EvaluationNotfoundException();
        }else{
            EvaluationDTO evaluationDTO = dataMapper.evaluationMapperToDTO(evaluation);
            evaluationDTO.setRubriques(evaluationService.getRubriqueEvaluation(evaluation.getIdEvaluation()));
            return new ResponseEntity<>(
                    evaluationDTO,
                    HttpStatus.FOUND);
        }
    }
}
