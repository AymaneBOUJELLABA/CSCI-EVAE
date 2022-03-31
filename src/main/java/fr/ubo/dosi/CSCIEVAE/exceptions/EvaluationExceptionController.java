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
                        " \t"
                        +e.getMessage(),
                HttpStatus.CONFLICT
        ); //Code UE ou Enseignant n'est pas valide !
    }

    @ExceptionHandler(EvaluationUpdateErrorException.class)
    public ResponseEntity<Object> handleEvaluationUpdateExceptions(Exception e) {
        return new ResponseEntity<>(
                "Problème pendant la modification de l'évalution. " +
                        "\n"
                        +e.getMessage(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(EvaluationRubQuesErrorException.class)
    public ResponseEntity<Object> handleEvaluationRubQuestionExceptions(Exception e) {
        return new ResponseEntity<>(
                "Problème pendant la modification de l'évalution. " +
                        "Conflict dans les questions d'evaluation ! \t"
                        +e.getMessage(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(RubriquesEvaluationErrorException.class)
    public ResponseEntity<Object> handleRubriquesEvaluationExceptions(Exception e) {
        return new ResponseEntity<>(
                "Problème pendant l'enregistrement des rubriqueq " +
                        "Conflict dans les rubriques d'évaluation ! \t"
                        +e.getMessage(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(QuestionsEvaluationErrorException.class)
    public ResponseEntity<Object> handleQuestionsEvaluationExceptions(Exception e) {
        return new ResponseEntity<>(
                "Problème pendant l'enregistrement des questions " +
                        "Conflict dans les questions d'évaluation ! \t"
                        +e.getMessage(),
                HttpStatus.CONFLICT
        );
    }


    @ExceptionHandler(AuthentificationNotFoundException.class)
    public ResponseEntity<Object> handleAuthentificationNotFoundExceptions(Exception e) {
        return new ResponseEntity<>(
                "Identifiant ou mot de passe erronés! \t"
                        +e.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }

}
