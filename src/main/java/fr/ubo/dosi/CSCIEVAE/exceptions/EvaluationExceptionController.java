package fr.ubo.dosi.CSCIEVAE.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EvaluationExceptionController {

    @ExceptionHandler(value = EvaluationNotfoundException.class)
    public ResponseEntity<Object> exception(EvaluationNotfoundException exception) {
        return new ResponseEntity<>(
                "Evaluation not found ! "+ exception.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(EvaluationErrorException.class)
    public ResponseEntity<Object> handleEvaluationExceptions(Exception e) {
        return new ResponseEntity<>(
                "Problème pendant la céation de l'évalution. " +
                        "Code UE ou Enseignant n'est pas valide ! \t"
                        +e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(EvaluationRubQuesErrorException.class)
    public ResponseEntity<Object> handleEvaluationRubQuestionExceptions(Exception e) {
        return new ResponseEntity<>(
                "Problème pendant la modification de l'évalution. " +
                        "Conflict dans les questions d'evaluation ! \t"
                        +e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

}
