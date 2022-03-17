package fr.ubo.dosi.CSCIEVAE.exceptions;

import org.springframework.http.HttpStatus;

public class UeErrorException extends RuntimeException {
	
	  private static final long serialVersionUID = 2L;

	    private HttpStatus status = null;

	    private Object data = null;

	    public UeErrorException() {
	        super();
	    }

	    public UeErrorException(
	            String message
	    ) {
	        super(message);
	    }

	    public UeErrorException(
	            HttpStatus status,
	            String message
	    ) {
	        this(message);
	        this.status = status;
	    }

	    public UeErrorException(
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
