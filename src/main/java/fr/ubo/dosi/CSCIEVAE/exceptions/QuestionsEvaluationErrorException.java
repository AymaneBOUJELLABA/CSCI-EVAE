package fr.ubo.dosi.CSCIEVAE.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter @Getter
public class QuestionsEvaluationErrorException extends RuntimeException {

    private static final long serialVersionUID = 5L;

    private HttpStatus status = null;

    private Object data = null;

    public QuestionsEvaluationErrorException() {
        super();
    }

    public QuestionsEvaluationErrorException(
            String message
    ) {
        super(message);
    }

    public QuestionsEvaluationErrorException(
            HttpStatus status,
            String message
    ) {
        this(message);
        this.status = status;
    }

    public QuestionsEvaluationErrorException(
            HttpStatus status,
            String message,
            Object data
    ) {
        this(
                status,
                message
        );
        this.data = data;
    }
}
