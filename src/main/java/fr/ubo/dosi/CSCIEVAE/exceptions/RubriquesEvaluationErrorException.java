package fr.ubo.dosi.CSCIEVAE.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RubriquesEvaluationErrorException extends RuntimeException{

    private static final long serialVersionUID = 4L;

    private HttpStatus status = null;

    private Object data = null;

    public RubriquesEvaluationErrorException() {
        super();
    }

    public RubriquesEvaluationErrorException(
            String message
    ) {
        super(message);
    }

    public RubriquesEvaluationErrorException(
            HttpStatus status,
            String message
    ) {
        this(message);
        this.status = status;
    }

    public RubriquesEvaluationErrorException(
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
