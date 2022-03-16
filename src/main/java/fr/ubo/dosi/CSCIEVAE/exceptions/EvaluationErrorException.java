package fr.ubo.dosi.CSCIEVAE.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class EvaluationErrorException extends RuntimeException{

    private static final long serialVersionUID = 2L;

    private HttpStatus status = null;

    private Object data = null;

    public EvaluationErrorException() {
        super();
    }

    public EvaluationErrorException(
            String message
    ) {
        super(message);
    }

    public EvaluationErrorException(
            HttpStatus status,
            String message
    ) {
        this(message);
        this.status = status;
    }

    public EvaluationErrorException(
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
