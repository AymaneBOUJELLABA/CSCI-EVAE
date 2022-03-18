package fr.ubo.dosi.CSCIEVAE.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class EvaluationRubQuesErrorException extends RuntimeException{

    private static final long serialVersionUID = 3L;

    private HttpStatus status = null;

    private Object data = null;

    public EvaluationRubQuesErrorException() {
        super();
    }

    public EvaluationRubQuesErrorException(
            String message
    ) {
        super(message);
    }

    public EvaluationRubQuesErrorException(
            HttpStatus status,
            String message
    ) {
        this(message);
        this.status = status;
    }

    public EvaluationRubQuesErrorException(
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
