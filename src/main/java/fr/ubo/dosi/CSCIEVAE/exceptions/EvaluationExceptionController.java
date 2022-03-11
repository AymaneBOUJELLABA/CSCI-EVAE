package fr.ubo.dosi.CSCIEVAE.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EvaluationExceptionController {

    @ExceptionHandler(value = EvaluationNotfoundException.class)
    public ResponseEntity<Object> exception(EvaluationNotfoundException exception) {
        return new ResponseEntity<>("Evaluation not found ! "+ exception.getMessage(),
                HttpStatus.NOT_FOUND);
    }
}
