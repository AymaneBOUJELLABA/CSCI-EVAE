package fr.ubo.dosi.CSCIEVAE.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class AuthentificationNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 2L;

    private HttpStatus status = null;

    private Object data = null;

    public AuthentificationNotFoundException() {
        super();
    }

    public AuthentificationNotFoundException(
            String message
    ) {
        super(message);
    }

    public AuthentificationNotFoundException(
            HttpStatus status,
            String message
    ) {
        this(message);
        this.status = status;
    }
}
