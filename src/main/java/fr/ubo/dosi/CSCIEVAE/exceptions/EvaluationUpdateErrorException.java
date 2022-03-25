package fr.ubo.dosi.CSCIEVAE.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class EvaluationUpdateErrorException extends RuntimeException{

    private static final long serialVersionUID = 2L;

    private HttpStatus status = null;

    private Object data = null;

    public EvaluationUpdateErrorException() {
        super();
    }

    public EvaluationUpdateErrorException(
            String message
    ) {
        super(message);
    }

    public EvaluationUpdateErrorException(
            HttpStatus status,
            String message
    ) {
        this(message);
        this.status = status;
    }

    public EvaluationUpdateErrorException(
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
